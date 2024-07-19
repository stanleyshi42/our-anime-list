package com.example.our_anime_list.controller;

import com.example.our_anime_list.entity.AuthRequest;
import com.example.our_anime_list.entity.User;
import com.example.our_anime_list.service.JwtService;
import com.example.our_anime_list.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    // Authenticates login info and returns a JWT
    @PostMapping("/auth")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("Error: Invalid user request");
        }
    }

    @PostMapping()
    public ResponseEntity addUser(@RequestBody User user) {
        user.setRoles("ROLE_USER");
        User result;

        try {
            result = userService.addUser(user);
        } catch (Exception e) {
            return ResponseEntity.status(400).body("Error: Username already registered");
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getByUsername(username);
    }

    @GetMapping("/all")
    public ArrayList<User> getAllEntries() {
        return (ArrayList<User>) userService.getAllUsers();
    }

    @PutMapping()
    public User updateUser(@RequestBody User user) {
        return userService.updateUsers(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUserById(@PathVariable long id) {
        userService.deleteUserById(id);
        return true;
    }

}
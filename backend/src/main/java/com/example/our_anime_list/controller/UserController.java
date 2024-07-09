package com.example.our_anime_list.controller;

import com.example.our_anime_list.entity.User;
import com.example.our_anime_list.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
<<<<<<< Updated upstream
=======
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

>>>>>>> Stashed changes
    @Autowired
    UserService service;

    @PostMapping()
<<<<<<< Updated upstream
    public User addUser(@RequestBody User user){
        return service.addUser(user);
    }
    @GetMapping("/{userId}")
    public ArrayList<User> getUsersById(@PathVariable long userid){
        return (ArrayList<User>) service.getUserByUserId(userid);
=======
    public User addUser(@RequestBody User user) {
        LOGGER.info("Adding user: {}",user);
        return userService.addUser(user);
>>>>>>> Stashed changes
    }

    @GetMapping("/user/{username}")
    public ArrayList<User> getUserByUsername(@PathVariable String username){
        return (ArrayList<User>) service.getByUsername(username);

    }

    @GetMapping("/all")
    public ArrayList<User> getAllEntries() {
        return (ArrayList<User>) service.getAllUsers();
    }

    @PutMapping()
    public User updateUser(User user) {
        return service.updateUsers(user);
    }

    @DeleteMapping("/{userId}")
    public boolean deleteUserById(long userId) {
        service.deleteUserById(userId);
        return true;
    }

}
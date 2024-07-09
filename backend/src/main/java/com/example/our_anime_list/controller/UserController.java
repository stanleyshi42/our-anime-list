package com.example.our_anime_list.controller;

import com.example.our_anime_list.entity.Users;
import com.example.our_anime_list.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService service;

    @PostMapping()
    public Users addUser(@RequestBody Users user){
        return service.addUser(user);
    }
    @GetMapping("/{userId}")
    public ArrayList<Users> getUsersById(@RequestBody long userid){
        return (ArrayList<Users>) service.getUserByUserId(userid);
    }

    @GetMapping("/all")
    public ArrayList<Users> getAllEntries() {
        return (ArrayList<Users>) service.getAllUsers();
    }

    @PutMapping()
    public Users updateUser(Users user) {
        return service.updateUsers(user);
    }

    @DeleteMapping("/{userId}")
    public boolean deleteUserById(long userId) {
        service.deleteUserById(userId);
        return true;
    }

}
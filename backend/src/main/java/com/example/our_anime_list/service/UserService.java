package com.example.our_anime_list.service;

import com.example.our_anime_list.repository.UserRepository;
import com.example.our_anime_list.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class UserService {
    @Autowired
    UserRepository repo;

    public User addUser(User user){ return repo.save(user);}

    public List<User>getUserByUserId(long userId){
        return repo.findByUserId(userId);
    }
    public List<User> getAllUsers(){
        return repo.findAll();
    }
    public User updateUsers(User user){
        return repo.save(user);
    }
    public void deleteUserById(long id){
        repo.deleteById(id);
    }
}

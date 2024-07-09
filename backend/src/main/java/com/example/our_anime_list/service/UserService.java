package com.example.our_anime_list.service;

import com.example.our_anime_list.repository.UserRepository;
import com.example.our_anime_list.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class UserService {
    @Autowired
    UserRepository repo;

    public Users addUser(Users user){ return repo.save(user);}

    public List<Users>getUserByUserId(long userId){
        return repo.findByUserId(userId);
    }
    public List<Users> getAllUsers(){
        return repo.findAll();
    }
    public Users updateUsers(Users user){
        return repo.save(user);
    }
    public void deleteUserById(long id){
        repo.deleteById(id);
    }
}

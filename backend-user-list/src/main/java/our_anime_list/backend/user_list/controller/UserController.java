package our_anime_list.backend.user_list.controller;

import our_anime_list.backend.user_list.service.UserService;
import our_anime_list.backend.user_list.entity.Users;
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
    @GetMapping()
    public ArrayList<Users> getUsersById(@RequestBody long id){
        return (ArrayList<Users>) service.getUserByUserId(id);
    }

    @GetMapping("/all")
    public ArrayList<Users> getAllEntries() {
        return (ArrayList<Users>) service.getAllUsers();
    }

    @PutMapping()
    public Users updateUser(Users user) {
        return service.updateUsers(user);
    }

    @DeleteMapping()
    public boolean deleteUserById(long id) {
        service.deleteUserById(id);
        return true;
    }

}
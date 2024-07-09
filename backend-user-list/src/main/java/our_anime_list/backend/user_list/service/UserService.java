package our_anime_list.backend.user_list.service;

import our_anime_list.backend.user_list.entity.Users;
import our_anime_list.backend.user_list.repository.UserRepository;
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

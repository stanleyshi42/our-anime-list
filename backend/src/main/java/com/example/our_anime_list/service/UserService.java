package com.example.our_anime_list.service;

import com.example.our_anime_list.repository.UserRepository;
import com.example.our_anime_list.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    UserRepository repo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userDetail = repo.findByUsername(username);

        return userDetail.map(OurUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    public User addUser(User user) {
        user.setPassword(encoder.encode(user.getPassword())); // Encode password
        return repo.save(user);
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserById(long id) {
        return repo.findById(id).orElse(null);
    }

    public User getByUsername(String username) {
        return repo.findByUsername(username).orElse(null);
    }

    public User updateUsers(User user) {
        return repo.save(user);
    }

    public void deleteUserById(long id) {
        repo.deleteById(id);
    }

}

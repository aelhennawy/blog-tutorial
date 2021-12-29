package com.example.blog.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User hi() {
        User user = new User("Ahmed", "ahmed@gm.com");
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public void createUser(User user) {
        Optional<User> userByEmail = userRepository.findUserByEmail(user.getEmail());

        if(userByEmail.isPresent())
            throw new IllegalStateException("Email already exists");

        userRepository.save(user);
    }

    public User getById(Long user_id) {
        return userRepository.findById(user_id).get();
    }
}

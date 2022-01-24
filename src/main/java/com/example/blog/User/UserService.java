package com.example.blog.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.core.pagination.sync.SdkIterable;
import software.amazon.awssdk.enhanced.dynamodb.model.Page;

import java.util.Iterator;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(User user){
        user.setPk("user#"+user.getId());
        user.setSk("user#"+user.getId());
        userRepository.save(user);
    }

    public Iterator<User> getUsers() {
        return userRepository.getAll();
    }

    public User updateUser(String id, User user) {
        user = user.setKeys(id, user);
        return userRepository.update(id, user);
    }

    public void deleteUser(String id) {
        User user = new User();
        user.setKeys(id, user);

        userRepository.delete(user);
    }
}

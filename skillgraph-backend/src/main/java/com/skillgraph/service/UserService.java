package com.skillgraph.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.skillgraph.model.User;
import com.skillgraph.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Save User
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get All Users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get User By Id
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Update User
    public User updateUser(Long id, User updatedUser) {

        User user = userRepository.findById(id).orElse(null);

        if (user != null) {

            user.setFullName(updatedUser.getFullName());
            user.setEmail(updatedUser.getEmail());
            user.setCollege(updatedUser.getCollege());
            user.setBranch(updatedUser.getBranch());
            user.setGithubUsername(updatedUser.getGithubUsername());

            return userRepository.save(user);
        }

        return null;
    }
}
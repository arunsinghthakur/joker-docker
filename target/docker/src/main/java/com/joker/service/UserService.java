package com.joker.service;

import com.joker.domain.User;
import com.joker.repository.UserRepository;

public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void save(User user) {
        userRepository.save(user.getUserId(), user.getName());
    }

    public User getUser(Long id) {
        return userRepository.get(id);
    }

    public void createUserTable() {
        userRepository.createUserTable();
    }
}

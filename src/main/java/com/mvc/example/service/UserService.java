package com.mvc.example.service;

import com.mvc.example.domain.User;
import com.mvc.example.repo.UserRepo;
import jakarta.persistence.EntityExistsException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User createUser(User user) {
        if (userRepo.existsByUsername(user.getUsername())) {
            throw new EntityExistsException(
                    String.format("user with username '%s' already exists", user.getUsername()));
        }

        return userRepo.save(user);
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
}

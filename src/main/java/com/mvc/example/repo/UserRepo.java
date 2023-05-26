package com.mvc.example.repo;

import com.mvc.example.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    boolean existsByUsername(String username);

}

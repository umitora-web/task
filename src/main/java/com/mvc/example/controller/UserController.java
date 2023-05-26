package com.mvc.example.controller;

import com.mvc.example.domain.User;
import com.mvc.example.service.UserService;
import com.mvc.example.util.ValidationUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAll() {
        return userService.getAllUsers();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid User user,
                                    BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body(ValidationUtil.getErrors(bindingResult));
        }

        return ResponseEntity.ok(userService.createUser(user));
    }

}

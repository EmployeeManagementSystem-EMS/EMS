package com.EmployeeManagementSystem.ems.controller;

import com.EmployeeManagementSystem.ems.model.User;
import com.EmployeeManagementSystem.ems.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")  // Add this line to enable CORS for this controller
public class UserController {

    @Autowired
    private UserRepo userRepo;

    // get all users
    @GetMapping("/users")
    // the "/users" is an url endpoint and this REST API will get called when a client enters http://localhost:8080/api/v1/users
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // create user with id already assigned
    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userRepo.save(user);
    }

}

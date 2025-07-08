package bce.ec.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bce.ec.demo.entities.User;
import bce.ec.demo.services.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin("*") // Allow all origins for demonstration purposes   
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/add")
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") int userId) {
        return userService.getUserById(userId);
    }

}

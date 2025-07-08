package bce.ec.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bce.ec.demo.entities.User;
import bce.ec.demo.services.UserService;
import ch.qos.logback.core.model.Model;

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

    @PostMapping("/add-users")
    public ResponseEntity<List<user>> createUsers(@RequestBody List<User> users) {
        return new ResponseEntity<>(null)
    }

    @GetMapping("/user/{id}")
    public UserDto getUser(@PathVariable("id") int id) {
        ModelMapper modelMapper = new ModelMapper();
        User userDb = userService.getUserById(id);
        return modelMapper.map(userDb, UserDto.class);
    }

    @GetMapping("/{userId}")
    public User getUsers(@PathVariable("userId") int userId) {
        return userService.getUserById(userId);
    }

    @PutMapping("/update/{userId}")
    public User updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
        user.setId(userId); // Ensure the ID is set for the update
        return userService.updateById(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {
        userService.deleteById(userId);
    }

    //nocontent
}

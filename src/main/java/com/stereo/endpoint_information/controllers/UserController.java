package com.stereo.endpoint_information.controllers;

import com.stereo.endpoint_information.models.User;
import com.stereo.endpoint_information.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{username}")
    public User getUsers(@PathVariable String username) {
        return userService.getUser(username);
    }

    @PostMapping("/register")
    public User addUser(@RequestBody User user) {

        userService.addUser(user);
        return user;

    }

    @PutMapping("/user/{username}")
    public User updateUserDetails(@PathVariable String username ,@RequestBody User user) {
        user.setUsername(username);
        userService.updateUser(user);
        return user;

    }

    @DeleteMapping("/user/{username}")
    public String removeUser(@PathVariable String username) {

        return userService.deleteUser(username);

    }

    public User getUserDetails(String username) {
        return userService.getUser(username);
    }
}

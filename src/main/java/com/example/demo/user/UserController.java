package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "get-users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(path = "add-user")
    public User createUser(@RequestBody User user){ return userService.createUser(user); }

    @DeleteMapping(path="delete-user/{userId}")
    public String deleteUser(@PathVariable("userId") Long Id){
        return userService.deleteUser(Id);
    }
}

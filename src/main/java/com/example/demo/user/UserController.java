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
    public String deleteUser(@PathVariable("userId") int Id){
        return userService.deleteUser(Id);
    }

    @PutMapping(path="update-user/{userId}")
    public String updateUser(@PathVariable("userId") int Id,
                           @RequestParam(required = false) String first_name,
                           @RequestParam(required = false) String last_name,
                           @RequestParam(required = false) String password){
        return userService.updateUser(Id, first_name, last_name, password);
    }
}

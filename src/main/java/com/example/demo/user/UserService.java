package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public String deleteUser(Long Id){

        Optional<User> user = userRepository.findById(Id);

        if(user.isPresent()){
            userRepository.deleteById(Id);
            return "User with id " + Id + " has been deleted";
        }else{
            return "User with id " + Id + " does not exist in the system";
        }
    }
}

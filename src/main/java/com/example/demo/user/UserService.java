package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
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

    public String deleteUser(int Id){

        Optional<User> user = userRepository.findById(Id);

        if(user.isPresent()){
            userRepository.deleteById(Id);
            return "User with id " + Id + " has been deleted";
        }else{
            return "User with id " + Id + " does not exist in the system";
        }
    }

    @Transactional
    public String updateUser(int Id, String first_name, String last_name, String password){
        User user = userRepository.findById(Id).orElseThrow(() -> new IllegalStateException("id does not exist"));

        if(first_name != null && first_name.length() > 0 && !Objects.equals(user.getFirst_name(),first_name)){
            user.setFirst_name(first_name);
        }

        if(last_name != null && last_name.length() > 0 && !Objects.equals(user.getLast_name(), last_name)){
            user.setLast_name(last_name);
        }

        if(password != null && password.length() > 0 && !Objects.equals(user.getPassword(),password)){
            user.setPassword(password);
        }

        return user.toString();
    }
}

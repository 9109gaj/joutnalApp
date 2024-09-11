package net.newlearning.journalApp.controller;

import net.newlearning.journalApp.Entity.User;
import net.newlearning.journalApp.Repository.UserRepository;
import net.newlearning.journalApp.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {



    @Autowired
private UserServices userServices;

    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public List<User>  getAllUser(){
        return userServices.getAll();
    }


    @PostMapping
    public  void createUser(@RequestBody User user) {
        userServices.saveNewUser(user);
    }
@PutMapping
    public ResponseEntity<?>  updateUser(@RequestBody User user){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String  userName =  authentication.getName();
        User userInDb = userServices.findByUserName(userName);

            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userServices.saveNewUser(userInDb);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

 @DeleteMapping
    public  ResponseEntity<?>  deleteUserById(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepository.deleteByUserName(authentication.getName());
        return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
 }

}

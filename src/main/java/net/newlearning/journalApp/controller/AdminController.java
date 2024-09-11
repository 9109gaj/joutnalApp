package net.newlearning.journalApp.controller;

import net.newlearning.journalApp.Entity.User;
import net.newlearning.journalApp.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/all-users")
    public  ResponseEntity<?> getAllUser(){
        List<User> all = userServices.getAll();

        if(all != null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PostMapping("/create-admin-user")
    public void createUser(@RequestBody User user){
        userServices.saveAdmin(user);
    }
}

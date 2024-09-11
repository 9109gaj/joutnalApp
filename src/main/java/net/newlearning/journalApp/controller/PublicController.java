package net.newlearning.journalApp.controller;

import net.newlearning.journalApp.Entity.User;
import net.newlearning.journalApp.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class PublicController {

    @Autowired
    private UserServices userServices;
    @GetMapping("/health-check")
    public String healtCheck(){
        return "OK";
    }

    @PostMapping("/create-user")
    public  void  createUser(@RequestBody User user){
        userServices.saveNewUser(user);
    }
}

package com.example.megazoneTraining2.Controller;

import com.example.megazoneTraining2.Models.User;
import com.example.megazoneTraining2.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping(path = "")
    List<User> getAllUser() {
        return userService.getAllUsers();
    }
}

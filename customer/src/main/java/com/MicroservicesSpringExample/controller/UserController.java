package com.MicroservicesSpringExample.controller;

import com.MicroservicesSpringExample.entity.User;
import com.MicroservicesSpringExample.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(maxAge = 3600, origins = "")
@RequestMapping("/user")
public class UserController {

    private final UserServiceImp userServiceImp;

    @Autowired
    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    //REGISTER AN USER
    @PostMapping("/register")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<User> registerUser(@RequestBody User user){
        return ResponseEntity.ok(userServiceImp.registerUser(user));
    }

    //TO LOGIN THE USER
//    @GetMapping("/login")
//    @CrossOrigin(origins = "http://localhost:3000")
//    public ResponseEntity<?>loginUser(@RequestParam String username, @RequestParam String password){
//        return ResponseEntity.ok(userService.loginUser(username, password));
//    }



    //TO GET ALL USERS
    @GetMapping("/all")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(userServiceImp.getAllUsers());
    }

    //GET USER BY ID
    @GetMapping("/find")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<User> getUserById(@RequestParam Integer userId){
        return ResponseEntity.ok(userServiceImp.getUserById(userId));
    }

    //DELETE A USER BY ID
//    @DeleteMapping("/delete")
//    @CrossOrigin(origins = "http://localhost:3000")
//    public ResponseEntity<Object> deleteUser(@RequestParam Integer id, @RequestParam Integer findId){
//        userServiceImp.deleteUser(id, findId);
//        return ResponseEntity.ok("Succesfully deleted User");
//    }



}


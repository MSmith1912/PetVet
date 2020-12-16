package com.Mark.PetVet.petVet.controllers;

import com.Mark.PetVet.petVet.models.User;
import com.Mark.PetVet.petVet.models.UserRequest;
import com.Mark.PetVet.petVet.services.GeneralService;
import com.Mark.PetVet.petVet.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/userController")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    GeneralService generalService;

    @Autowired
    UserService userService;

    @PostMapping("CreateUser")
    public ResponseEntity<User> createUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.ok(userService.createUser(userRequest));
    }

    @GetMapping("/GetAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(generalService.getAllUsers());
    }

    @GetMapping("GetUserById/{user_id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("user_id") int user_id) {
        return ResponseEntity.ok(generalService.findUserById(user_id));
    }

    @PatchMapping("DeleteUserById/{user_id}")
    public void deleteUserById(@PathVariable("user_id") int user_id) {
        generalService.deleteUserById(user_id);
    }
}

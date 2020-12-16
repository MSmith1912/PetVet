package com.Mark.PetVet.petVet.controllers;

import com.Mark.PetVet.petVet.models.User;
import com.Mark.PetVet.petVet.services.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/userController")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    GeneralService generalService;

    @GetMapping("/GetAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(generalService.getAllUsers());
    }

    @GetMapping("GetUserById/{user_id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable("user_id") int user_id) {
        return ResponseEntity.ok(generalService.findUserById(user_id));
    }
}

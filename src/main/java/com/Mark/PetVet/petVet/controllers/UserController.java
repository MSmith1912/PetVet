package com.Mark.PetVet.petVet.controllers;

import com.Mark.PetVet.petVet.models.User;
import com.Mark.PetVet.petVet.services.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/userController")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    GeneralService generalService;

    @GetMapping("/GetAllUsers")
    public ResponseEntity<List<User>> getAllUsers() {
//        List<User> usersForFront = generalService.getAllUsers();
//        return ResponseEntity.ok(usersForFront);
        return ResponseEntity.ok(generalService.getAllUsers());
    }
}

package com.Mark.PetVet.petVet.services;

import com.Mark.PetVet.petVet.models.User;
import com.Mark.PetVet.petVet.models.UserRequest;
import com.Mark.PetVet.petVet.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User createUser(UserRequest userRequest) {
        User newUser = new User();
        newUser.setUsername(userRequest.getUsername());
        newUser.setPassword(userRequest.getPassword());
        newUser.setFirstName(userRequest.getFirstName());
        newUser.setLastName(userRequest.getLastName());
        newUser.setDOB(userRequest.getDob());
        newUser.setAccess(userRequest.getAccess());
        userDao.save(newUser);
        return newUser;
    }
}

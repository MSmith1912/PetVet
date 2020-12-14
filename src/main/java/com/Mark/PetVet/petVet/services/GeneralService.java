package com.Mark.PetVet.petVet.services;

import com.Mark.PetVet.petVet.models.Animal;
import com.Mark.PetVet.petVet.models.User;
import com.Mark.PetVet.petVet.repositories.GeneralDao;
import com.Mark.PetVet.petVet.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeneralService {

    @Autowired
    GeneralDao generalDao;

    @Autowired
    UserDao userDao;

    // ANIMAL METHODS

    public Animal save(Animal animal) {
        return generalDao.save(animal);
    }

    public Optional<Animal> findByAnimalId(int animalId) {
        return generalDao.findAnimalById(animalId);
    }


    // USER METHODS

    public User save(User user) {
        return userDao.save(user);
    }
}

package com.Mark.PetVet.petVet.services;

import com.Mark.PetVet.petVet.models.Animal;
import com.Mark.PetVet.petVet.models.User;
import com.Mark.PetVet.petVet.repositories.AnimalDao;
import com.Mark.PetVet.petVet.repositories.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeneralService {

    @Autowired
    AnimalDao animalDao;

    @Autowired
    UserDao userDao;

    // ANIMAL METHODS

    public Animal save(Animal animal) {
        return animalDao.save(animal);
    }

    public Optional<Animal> findByAnimalId(int animalId) {
        return animalDao.findAnimalById(animalId);
    }


    // USER METHODS

    public User save(User user) {
        return userDao.save(user);
    }

    public Optional<User> findUserById(int userId) {
        return userDao.findById(userId);
    }

    public List<Animal> findUserPets(int userId) {
        return animalDao.findUsersPets(userId);
    }
}

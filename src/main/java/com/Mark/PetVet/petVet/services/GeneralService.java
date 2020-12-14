package com.Mark.PetVet.petVet.services;

import com.Mark.PetVet.petVet.models.Animal;
import com.Mark.PetVet.petVet.repositories.GeneralDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GeneralService {

    @Autowired
    GeneralDao generalDao;

    public Animal save(Animal animal) {
        return generalDao.save(animal);
    }

    public Optional<Animal> findByAnimalId(int animalId) {
        return generalDao.findAnimalById(animalId);
    }
}

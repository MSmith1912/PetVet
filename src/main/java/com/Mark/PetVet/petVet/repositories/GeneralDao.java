package com.Mark.PetVet.petVet.repositories;

import com.Mark.PetVet.petVet.models.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface GeneralDao extends JpaRepository<Animal, Integer> {

    @Query(value="SELECT * FROM animal WHERE animal_Id = ?", nativeQuery = true)
    public Optional<Animal> findAnimalById(int animalId);
}

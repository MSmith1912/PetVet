package com.Mark.PetVet.petVet.repositories;

import com.Mark.PetVet.petVet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

}

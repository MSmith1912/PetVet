package com.Mark.PetVet.petVet.repositories;

import com.Mark.PetVet.petVet.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserDao extends JpaRepository<User, Integer> {

    @Query(value="SELECT * FROM users", nativeQuery = true)
    List<User> findAllUsers();
}

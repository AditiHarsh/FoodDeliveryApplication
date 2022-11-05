package com.example.Restaurant.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Restaurant.entities.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

}

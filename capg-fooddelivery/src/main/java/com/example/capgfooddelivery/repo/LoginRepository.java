package com.example.capgfooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.capgfooddelivery.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String> {

}
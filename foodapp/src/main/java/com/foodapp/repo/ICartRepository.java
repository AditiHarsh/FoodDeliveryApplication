package com.foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.entities.FoodCart;



@Repository
public interface ICartRepository extends JpaRepository<FoodCart, String>{

}

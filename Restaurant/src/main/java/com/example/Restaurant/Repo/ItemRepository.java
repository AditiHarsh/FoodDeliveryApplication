package com.example.Restaurant.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Restaurant.entities.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

}

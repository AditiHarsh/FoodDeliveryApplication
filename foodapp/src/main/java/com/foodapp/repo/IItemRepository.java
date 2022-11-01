package com.foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.entities.Item;

public interface IItemRepository extends JpaRepository<Item,String> {

}

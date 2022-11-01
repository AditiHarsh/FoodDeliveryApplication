package com.example.capgfooddelivery.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.capgfooddelivery.entity.OrderDetails;

public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Integer> {

}

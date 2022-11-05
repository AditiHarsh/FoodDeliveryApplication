package com.example.Restaurant.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Restaurant.entities.Item;
import com.example.Restaurant.entities.Restaurant;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
	
	@Query("select r from Restaurant e inner join e.items r where e.rest_id=:i")
	List<Item> getItemsOfARestaurant(@Param("i") int id);
	
	@Query("select e from Restaurant e inner join e.address a where a.city=:c")
	List<Restaurant> getRestaurantsByCity(@Param("c") String city);
	
	@Query("select e from Restaurant e inner join e.address a where a.area=:are")
	List<Restaurant> getRestaurantsByArea(@Param("are") String area);

}

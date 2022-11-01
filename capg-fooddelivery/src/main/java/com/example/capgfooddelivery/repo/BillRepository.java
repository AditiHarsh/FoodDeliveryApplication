package com.example.capgfooddelivery.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.capgfooddelivery.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {

	@Query("select b from Bill b where b.billDate between :start and :end")
	List<Bill> viewBillsByDate(@Param("start") LocalDateTime start,@Param("end") LocalDateTime end);

	@Query("select b from Bill b where b.orderdetail.orderId=:orderId")
	Bill findByOrderId(@Param("orderId") int orderId);


}

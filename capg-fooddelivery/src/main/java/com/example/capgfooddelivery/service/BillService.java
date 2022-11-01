package com.example.capgfooddelivery.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.example.capgfooddelivery.entity.Bill;
import com.example.capgfooddelivery.exception.BillAlreadyExistsException;
import com.example.capgfooddelivery.exception.BillNotFoundException;

public interface BillService {

	Bill addBill(Bill bill) throws BillAlreadyExistsException;

	Bill viewBill(int billId) throws BillNotFoundException;

	List<Bill> viewBillHistory() throws BillNotFoundException;

	Bill updateBill(Bill bill);

	String removeBill(int billId) throws BillNotFoundException;

	String removeAllBills();

	List<Bill> viewBillsByDate(LocalDateTime start, LocalDateTime end) throws BillNotFoundException;

	Bill viewBillByOrderId(int orderId);

}

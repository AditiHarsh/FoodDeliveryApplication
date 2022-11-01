package com.example.capgfooddelivery.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.capgfooddelivery.entity.Bill;
import com.example.capgfooddelivery.exception.BillAlreadyExistsException;
import com.example.capgfooddelivery.exception.BillNotFoundException;
import com.example.capgfooddelivery.service.BillService;

@RestController
public class BillController {

	@Autowired
	BillService billserv;
	
	@PostMapping("/addbill")
	public ResponseEntity<Bill> addBill(@RequestBody Bill bill) throws BillAlreadyExistsException{
		Bill saveBill=billserv.addBill(bill);
		return new ResponseEntity<Bill>(saveBill,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/viewbill/{billId}")
	public ResponseEntity<Bill> viewBill(@PathVariable int billId) throws BillNotFoundException{
		Bill getBill=billserv.viewBill(billId);
		return new ResponseEntity<Bill>(getBill,HttpStatus.OK);
	}
	
	@GetMapping("/viewbillbyorderid/{orderId}")
	public ResponseEntity<Bill> viewBillByOrderId(@PathVariable int orderId){
		Bill getBill=billserv.viewBillByOrderId(orderId);
		return new ResponseEntity<Bill>(getBill,HttpStatus.OK);
	}
	
	@GetMapping("/viewbillhistory")
	public ResponseEntity<List<Bill>> viewBillHistory() throws BillNotFoundException{
		List<Bill> getBills=billserv.viewBillHistory();
		return new ResponseEntity<List<Bill>>(getBills,HttpStatus.OK);
	}
	
	@GetMapping("/viewbilldatewise/{startDate}/{endDate}")
	public ResponseEntity<List<Bill>> viewBillsByDate(@PathVariable String startDate,@PathVariable String endDate) throws BillNotFoundException{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		LocalDateTime start = LocalDateTime.parse(startDate, formatter);
		LocalDateTime end = LocalDateTime.parse(endDate, formatter);
		List<Bill> getBills=billserv.viewBillsByDate(start,end);
		return new ResponseEntity<List<Bill>>(getBills,HttpStatus.OK);
	}
	
	@PutMapping("/updatebill")
	public ResponseEntity<Bill> updateBill(@RequestBody Bill bill){
		Bill updatedBill=billserv.updateBill(bill);
		return new ResponseEntity<Bill>(updatedBill,HttpStatus.OK);
	}
	
	@DeleteMapping("/removebill/{billId}")
	public String removeBill(@PathVariable int billId) throws BillNotFoundException {
		String deleted=billserv.removeBill(billId);
		return deleted;
	}
	
	@DeleteMapping("/removeallbills")
	public String removeAllBills() {
		String deleted=billserv.removeAllBills();
		return deleted;
	}
}

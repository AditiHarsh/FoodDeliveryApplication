package com.example.capgfooddelivery.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capgfooddelivery.entity.Bill;
import com.example.capgfooddelivery.exception.BillAlreadyExistsException;
import com.example.capgfooddelivery.exception.BillNotFoundException;
import com.example.capgfooddelivery.repo.BillRepository;

@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepo;
	
	@Override
	public Bill addBill(Bill bill) throws BillAlreadyExistsException {
		if(billRepo.existsById(bill.getBillId()))
			throw new BillAlreadyExistsException();
		Bill saved=billRepo.save(bill);
		return saved;
	}

	@Override
	public Bill viewBill(int billId) throws BillNotFoundException {
		if(billRepo.existsById(billId))
		{
			Bill viewbill=billRepo.findById(billId).get();
			return viewbill;
		}
		throw new BillNotFoundException();
		
	}
	
	@Override
	public Bill viewBillByOrderId(int orderId) {
		Bill viewbill=billRepo.findByOrderId(orderId);
		return viewbill;
	}

	@Override
	public List<Bill> viewBillHistory() throws BillNotFoundException {
		List<Bill> billHistory=billRepo.findAll();
		if(billHistory.isEmpty())
			throw new BillNotFoundException();
		return billHistory;
	}
	
	@Override
	public List<Bill> viewBillsByDate(LocalDateTime start,LocalDateTime end) throws BillNotFoundException {
		List<Bill> bills=billRepo.viewBillsByDate(start,end);
		if(bills.isEmpty())
			throw new BillNotFoundException();
		return bills;
	}

	@Override
	public Bill updateBill(Bill bill) {
		Bill updated=billRepo.save(bill);
		return updated;
	}

	@Override
	public String removeBill(int billId) throws BillNotFoundException {
		if(billRepo.existsById(billId))
		{
			billRepo.deleteById(billId);
			return "Deleted Successfully!";
		}
		throw new BillNotFoundException();
	}

	@Override
	public String removeAllBills() {
		billRepo.deleteAll();
		return "All bills are deleted!";
	}


}

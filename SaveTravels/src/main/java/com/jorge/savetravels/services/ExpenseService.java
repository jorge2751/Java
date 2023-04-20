package com.jorge.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jorge.savetravels.models.Expense;
import com.jorge.savetravels.repositories.ExpenseRepository;

@Service
public class ExpenseService {
	
	// -------- REPOSITORY INSTANCE -----------
	private final ExpenseRepository expenseRepo;

	public ExpenseService(ExpenseRepository expenseRepo) {
		this.expenseRepo = expenseRepo;
	}
	
	// --------------- READ ------------------
	public List<Expense> getAll(){
		return (List<Expense>) expenseRepo.findAll();
	}
	
	public Expense findOne(Long id) {
		Optional<Expense> expense = expenseRepo.findById(id);
		if(expense.isPresent()) {
			return expense.get();
		}else {
			return null;
		}
	}
	
	
	// --------------- CREATE ------------------
	public Expense create(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	
	// --------------- UPDATE ------------------
	public Expense edit(Expense expense) {
		return expenseRepo.save(expense);
	}
	
	
	// --------------- DELETE ------------------
	public void deleteExpense(Long id) {
		expenseRepo.deleteById(id);
	}

}

package com.jorge.savetravels.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.savetravels.models.Expense;
import com.jorge.savetravels.services.ExpenseService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	private final ExpenseService expenseServ;
	

	public ApiController(ExpenseService expenseServ) {
		this.expenseServ = expenseServ;
	}
	
	@GetMapping("/expenses")
	public List<Expense> findAllExpenses(){
		return expenseServ.getAll();
	}
	
	@PostMapping("/expenses")
	public Expense createExpense(@RequestParam("name") String name, @RequestParam("vendor") String vendor, @RequestParam("amount") Double amount, @RequestParam("description") String description) {
		Expense newExpense = new Expense(name, vendor, amount, description);
		return expenseServ.create(newExpense);
	}
	
	@GetMapping("/expenses/{id}")
	public Expense findOneExpense(@PathVariable("id") Long id) {
		return expenseServ.findOne(id);
	}
	
	@PutMapping("/expenses/{id}")
	public Expense editOneExpense(@PathVariable("id") Long id, @RequestParam("name") String name, @RequestParam("vendor") String vendor, @RequestParam("amount") Double amount, @RequestParam("description") String description) {
		Expense foundExpense = expenseServ.findOne(id);
		if(foundExpense == null) {
			return foundExpense;
		}
		
		foundExpense.setName(name);
		foundExpense.setVendor(vendor);
		foundExpense.setAmount(amount);
		foundExpense.setDescription(description);
		
		return expenseServ.edit(foundExpense);
	}
	
	@DeleteMapping("/expenses/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		expenseServ.deleteExpense(id);
		return id + " has been deleted.";
	}
	

}

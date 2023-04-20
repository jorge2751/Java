package com.jorge.savetravels.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jorge.savetravels.models.Expense;
import com.jorge.savetravels.services.ExpenseService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/expenses")
public class ExpenseController {
	
	
	// ---------- SERVICE INSTANCE -------------
	public final ExpenseService expenseServ;

	public ExpenseController(ExpenseService expenseServ) {
		this.expenseServ = expenseServ;
	}
	
	
	// --------------- READ ------------------
	@GetMapping("/all")
	public String allExpenses(Model model, @ModelAttribute("expense") Expense expense) {
		model.addAttribute("allExpenses", expenseServ.getAll());
		return "expense/showAll.jsp";
	}
	
	@GetMapping("/display/{id}")
	public String oneExpense(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseServ.findOne(id);
		model.addAttribute("expense", expense);
		return "expense/display.jsp";
	}
	
	
	// --------------- CREATE ------------------
	// Version 1
	@GetMapping("/create")
	public String createExpense(@ModelAttribute("expense") Expense expense) {
		return "expense/create.jsp";
	}
	
	// Version 2
	@PostMapping("/process/create")
	public String processCreateExpense(@Valid @ModelAttribute("expense") Expense newExpense, BindingResult result, Model model) {
		if(result.hasErrors()) {
			model.addAttribute("allExpenses", expenseServ.getAll());
			return "expense/showAll.jsp";
		}
		expenseServ.create(newExpense);
		return "redirect:/expenses/all";
	}
	
	
	// --------------- UPDATE ------------------
	@GetMapping("/edit/{id}")
	public String editExpense(@PathVariable("id") Long id, Model model) {
		Expense expense = expenseServ.findOne(id);
		model.addAttribute("expense", expense);
		return "expense/edit.jsp";
	}
	
	@PutMapping("/process/edit/{id}")
	public String processEditExpense(@Valid @ModelAttribute("expense") Expense expense, BindingResult result, @PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "expense/edit.jsp";
		}
		expenseServ.edit(expense);
		return "redirect:/expenses/display/" + id;
	}
	
	
	// --------------- DELETE ------------------
	@DeleteMapping("/delete/{id}")
	public String deleteExpense(@PathVariable("id") Long id) {
		expenseServ.deleteExpense(id);
		return "redirect:/expenses/all";
	}

}

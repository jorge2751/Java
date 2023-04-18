package com.jorge.omikujiform.controllers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class FormController {
	
	@GetMapping("/omikuji")
	public String newOmikuji() {
		return "form.jsp";
	}
	
	@PostMapping("/process/omikuji")
	public String processOmikuji(@RequestParam("num") int num, @RequestParam("city") String city, @RequestParam("person") String person, @RequestParam("hobby") String hobby, @RequestParam("thing") String thing, @RequestParam("nice") String nice, HttpSession session) {
		session.setAttribute("num", num);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("thing", thing);
		session.setAttribute("nice", nice);
		return "redirect:/omikuji/show";
	}
	
	@GetMapping("/omikuji/show")
	public String showOmikuji() {
		return "result.jsp";
	}
}

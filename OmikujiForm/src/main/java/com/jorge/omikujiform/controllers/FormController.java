package com.jorge.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
	
	@GetMapping("/omikuji")
	public String newOmikuji() {
		return "form.jsp";
	}
	
	@GetMapping("/omikuji/show")
	public String newOmikuji(@RequestParam("num") int num, @RequestParam("city") String city, @RequestParam("person") String person, @RequestParam("hobby") String hobby, @RequestParam("thing") String thing, @RequestParam("nice") String nice, Model model) {
		model.addAttribute("num", num);
		model.addAttribute("city", city);
		model.addAttribute("person", person);
		model.addAttribute("hobby", hobby);
		model.addAttribute("thing", thing);
		model.addAttribute("nice", nice);
		return "result.jsp";
	}
}

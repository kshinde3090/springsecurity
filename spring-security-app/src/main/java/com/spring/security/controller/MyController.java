package com.spring.security.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/admin/index")
	public String index(Model model,Principal principal) {
		System.out.println("index mapping");
		//model.addAttribute("message","you are logged in as "+principal.getName());
		return "admin";
	}
	@GetMapping("/")
	public String index1(Model model,Principal principal) {
		System.out.println("index mapping");
		//model.addAttribute("message","you are logged in as "+principal.getName());
		return "index";
	}
	@GetMapping("/index")
	public String welcomepage(Model model,Principal principal) {
		System.out.println("index mapping");
		//model.addAttribute("message","you are logged in as "+principal.getName());
		return "welcomepage";
	}
	

	
}

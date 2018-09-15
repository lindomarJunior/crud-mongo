package com.crudmongo.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CrudMongoController {
	
	@GetMapping("/Login")
	public String login() {
		return "Login";
	}
	
	@GetMapping("/")
	public String home() {
		return "Home";
	}
	
	@GetMapping("/Admin")
	public String administracao() {
		return "Admin";
	}
	
	@GetMapping("/Gerencia")
	public String gerencia() {
		return "Gerencia";
	}
	
	@GetMapping("/Cliente")
	public String cliente() {
		return "Cliente";
	}
}

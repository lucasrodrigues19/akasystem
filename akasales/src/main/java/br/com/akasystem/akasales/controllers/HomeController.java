package br.com.akasystem.akasales.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.akasystem.akasales.domains.dto.AKAOrderDTO;

@RequestMapping(value = "/home")
@Controller
public class HomeController {

	@GetMapping
	public String getHome(Model model) {
		AKAOrderDTO order = new AKAOrderDTO();
		return "home";
	}
	
}

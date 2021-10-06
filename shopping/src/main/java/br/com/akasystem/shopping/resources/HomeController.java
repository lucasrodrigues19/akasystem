package br.com.akasystem.shopping.resources;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Lucas Rodrigues
 * @since 2021/08/28
 */
@RequestMapping(value = "/home")
@Controller
public class HomeController {

	@GetMapping
	public String getHome(Model model) {
		
	    return "home";
	}
	
}

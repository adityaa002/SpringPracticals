package in.co.rays.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class WelcomeCtl {

	@GetMapping
	public String display(Model model) {
		model.addAttribute("message", "Welcome to Spring MVC...!");
		return "WelcomeView";

	}
}

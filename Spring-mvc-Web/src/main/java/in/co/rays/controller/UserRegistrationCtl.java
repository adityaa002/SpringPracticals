package in.co.rays.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import in.co.rays.form.UserRegistrationForm;

@Controller
@RestController(value = "/UserRegistration")
public class UserRegistrationCtl {

	@GetMapping
	public String display(@ModelAttribute("form") UserRegistrationForm form) {
		System.out.println("in get display method");
		return "UserRegistrationView";
	}

}

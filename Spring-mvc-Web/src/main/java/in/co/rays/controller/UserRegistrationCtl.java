package in.co.rays.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.co.rays.dto.UserDTO;
import in.co.rays.form.UserRegistrationForm;
import in.co.rays.service.UserServiceInt;

@Controller
@RequestMapping(value = "UserRegistrationCtl")
public class UserRegistrationCtl {

	@Autowired
	public UserServiceInt service;

	@GetMapping
	public String display(@ModelAttribute("form") UserRegistrationForm form) {
		System.out.println("in get display method");
		return "UserRegistrationView";
	}

	@PostMapping
	public String submit(@ModelAttribute("form") UserRegistrationForm form, Model model,
			@RequestParam(required = false) String operation) {

		if (operation.equalsIgnoreCase("signIn")) {
			return "redirect:LoginCtl";
		} else if (operation.equalsIgnoreCase("reset")) {
			return "redirect:UserRegistrationCtl";
		}

		UserDTO dto = new UserDTO();

		dto.setId(form.getId());
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLogin(form.getLogin());
		dto.setPassword(form.getPassword());
		dto.setAddress(form.getAddress());

		service.add(dto);

		model.addAttribute("successMessage", "user register successfully");

		return "UserRegistrationView";

	}

}

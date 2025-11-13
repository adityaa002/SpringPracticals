package in.co.rays.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.rays.form.AddUserForm;
import in.co.rays.service.UserServiceInt;

@Controller
@RequestMapping(value = "/UserCtl")
public class UserCtl {

	@Autowired
	public UserServiceInt service;

	@GetMapping
	public String display(@ModelAttribute("form") AddUserForm form, @RequestParam(required = false) String operation) {
		System.out.println("in userCtl display method");
		return "UserView";

	}

	@PostMapping
	public String submit() {
		return null;

	}

}

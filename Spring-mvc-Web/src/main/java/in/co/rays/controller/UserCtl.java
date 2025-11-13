package in.co.rays.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.rays.dto.UserDTO;
import in.co.rays.form.UserForm;
import in.co.rays.service.UserServiceInt;

@Controller
@RequestMapping(value = "/UserCtl")
public class UserCtl {

	@Autowired
	public UserServiceInt service;

	@GetMapping
	public String display(@ModelAttribute("form") UserForm form, @RequestParam(required = false) String operation) {
		System.out.println("in userCtl display method");
		return "UserView";

	}

	@PostMapping
	public String submit(@ModelAttribute("form") UserForm form, @RequestParam(required = false) String operation,
			Model model) {

		if (operation != null && operation.equalsIgnoreCase("reset")) {

			return "redirect:UserCtl";

		} else if (operation.equalsIgnoreCase("save")) {

			UserDTO dto = new UserDTO();
			dto.setFirstName(form.getFirstName());
			dto.setLastName(form.getLastName());
			dto.setLogin(form.getLogin());
			dto.setPassword(form.getPassword());

			long id = service.add(dto);
			model.addAttribute("successMessage", "User Added Successfully..!");

		}

		return "UserView";
	}

	@GetMapping("UserList")
	public String display(@ModelAttribute("form") UserForm from, @RequestParam(required = false) ) {
		
		return "UserListView";

	}

}

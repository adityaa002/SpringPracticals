package in.co.rays.controller;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.co.rays.dto.UserDTO;
import in.co.rays.form.LoginForm;
import in.co.rays.service.UserServiceInt;

@Controller
@RequestMapping(value = "/LoginCtl")
public class LoginCtl {

	@Autowired
	public UserServiceInt service;

	@GetMapping
	public String display(@ModelAttribute("form") LoginForm form, @RequestParam(required = false) String operation,
			HttpSession session, Model model) {

		if (operation != null && operation.equals("logout")) {
			session.invalidate();
			model.addAttribute("successMessage", "User Logout Successfully...!");
			return "LoginView";
		}

		return "LoginView";

	}

	@PostMapping
	public String submit(@ModelAttribute("form") @Valid LoginForm form, BindingResult bindingResult, Model model,
			@RequestParam(required = false) String operation, HttpSession session) {
		if (bindingResult.hasErrors()) {
			
			if (operation != null && operation.equals("signUp")) {
				return "redirect:UserRegistrationCtl";

			}

			return "LoginView";
		}

		UserDTO dto = service.authenticate(form.getLogin(), form.getPassword());

		if (dto != null) {
			session.setAttribute("user", dto);
			return "redirect:WelcomeCtl";
		}

		return "LoginView";

	}

}

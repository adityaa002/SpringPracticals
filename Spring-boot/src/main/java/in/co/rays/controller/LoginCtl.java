package in.co.rays.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.rays.common.BaseCtl;
import in.co.rays.common.ORSResponse;
import in.co.rays.dto.UserDTO;
import in.co.rays.form.LoginForm;
import in.co.rays.form.UserRegistrationForm;
import in.co.rays.service.UserServiceInt;

@RestController
@RequestMapping("/Auth")
public class LoginCtl extends BaseCtl {

	@Autowired
	public UserServiceInt userService;

	@PostMapping("/login")
	public ORSResponse login(@RequestBody @Valid LoginForm form, BindingResult bindingResult, HttpSession session) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {

			return res;
		}
		

		UserDTO dto = userService.authenticate(form.getLoginId(), form.getPassword());
		if (dto != null) {
			session.setAttribute("user", dto);
			res.addData(dto);
			res.addMessage("User Login Successfully...!!");
			res.setSuccess(true);
			return res;

		} else {
			res.addMessage("Invalid credentials..!");
			res.setSuccess(false);
		}
		return res;

	}

	@PostMapping("/signUp")
	public ORSResponse signUp(@RequestBody @Valid UserRegistrationForm form, BindingResult bindingResult) {

		ORSResponse res = validate(bindingResult);

		if (!res.isSuccess()) {
			return res;
		}

		UserDTO dto = new UserDTO();

		dto = (UserDTO) form.getDto();

		long pk = userService.add(dto);

		res.addData(pk);
		res.addMessage("User Registered Successfully..!");

		return res;

	}

	@PostMapping("/logout")
	public ORSResponse logout(HttpSession session) {
		ORSResponse res = new ORSResponse();

		System.out.println("Session id --> " + session.getId());
		if (session.getId() != null) {
			session.invalidate();
			res.addMessage("Logout Successfully...!");
			res.setSuccess(true);
			return res;
		}
		return res;
	}
}

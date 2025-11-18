package in.co.rays.controller;

import java.util.ArrayList;
import java.util.List;

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
import in.co.rays.form.UserForm;
import in.co.rays.service.UserServiceInt;

@Controller
@RequestMapping(value = "/ctl/User")
public class UserCtl {

	@Autowired
	public UserServiceInt service;

	@GetMapping
	public String display(@ModelAttribute("form") UserForm form, @RequestParam(required = false) Long id) {

		if (id != null && id > 0) {

			UserDTO dto = service.findByPk(id);
			form.setId(dto.getId());
			form.setFirstName(dto.getFirstName());
			form.setLastName(dto.getLastName());
			form.setLogin(dto.getLogin());
			form.setPassword(dto.getPassword());
			form.setAddress(dto.getAddress());

		}

		System.out.println("in userCtl display method");
		return "UserView";

	}

	@PostMapping
	public String submit(@ModelAttribute("form") @Valid UserForm form, @RequestParam(required = false) String operation,
			BindingResult bindingResult, Model model) {

		System.out.println("Operation : " + operation);
		
		if ("reset".equalsIgnoreCase(operation)) {

			System.out.println("Got reset as operation..!");
			return "redirect:/ctl/User";

		} 

		if (bindingResult.hasErrors()) {
			return "UserView";
		}

		if ("cancel".equalsIgnoreCase(operation)) {

			System.out.println("Got cancel as operation..!");
			return "redirect:/ctl/User/search";

		}

		UserDTO dto = new UserDTO();

		dto.setId(form.getId());
		dto.setFirstName(form.getFirstName());
		dto.setLastName(form.getLastName());
		dto.setLogin(form.getLogin());
		dto.setPassword(form.getPassword());
		dto.setAddress(form.getAddress());

		if ("update".equalsIgnoreCase(operation)) {

			service.update(dto);

			model.addAttribute("successMessage", "Record Updated Successfully");

		} else if ("save".equalsIgnoreCase(operation)) {

			try {
				service.add(dto);

				model.addAttribute("successMessage", "Record Added Successfully");

			} catch (Exception e) {

				model.addAttribute("errorMessage", e.getMessage());

				e.printStackTrace();
			}
		}

		return "UserView";
	}

	@GetMapping("search")
	public String display(@ModelAttribute("form") UserForm form, Model model) {

		int pageNo = 1;
		int pageSize = 5;

		List list = service.search(null, pageNo, pageSize);

		form.setPageNo(pageNo);

		model.addAttribute("list", list);

		return "UserListView";

	}

	@PostMapping("search")
	public String submit(@ModelAttribute("form") UserForm form, Model model,
			@RequestParam(required = false) String operation) {

		UserDTO dto = null;

		int pageNo = 1;
		int pageSize = 5;

		System.out.println("operation ==> " + operation);

		if (operation != null && operation.equalsIgnoreCase("add")) {
			return "redirect:/ctl/User";

		}
		if (operation != null && operation.equalsIgnoreCase("reset")) {
			return "redirect:/ctl/User/search";

		}

		if (operation != null && operation.equalsIgnoreCase("next")) {

			pageNo = form.getPageNo();
			pageNo++;

		}
		if (operation != null && operation.equalsIgnoreCase("previous")) {

			pageNo = form.getPageNo();
			pageNo--;

		}

		if (operation != null && operation.equalsIgnoreCase("search")) {
			dto = new UserDTO();
			dto.setFirstName(form.getFirstName());
			dto.setLogin(form.getLogin());

		}

		if (operation != null && operation.equalsIgnoreCase("delete")) {
			if (form.getIds() != null && form.getIds().length > 0) {
				for (long id : form.getIds()) {
					UserDTO deleteDto = new UserDTO();
					deleteDto.setId(id);
					service.delete(deleteDto);
					model.addAttribute("successMessage", "Record(s) deleted successfully");

				}

			} else {
				model.addAttribute("errorMessage", "Select atleast one record");
			}

		}

		form.setPageNo(pageNo);

		List list = service.search(dto, pageNo, pageSize);

		model.addAttribute("list", list);

		return "UserListView";

	}

}

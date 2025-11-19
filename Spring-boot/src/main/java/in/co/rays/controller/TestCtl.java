package in.co.rays.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.co.rays.common.ORSResponse;
import in.co.rays.dto.TestDTO;

@RestController
@RequestMapping("test")
public class TestCtl {

	@GetMapping("display")
	public String display() {
		return "in display method";

	}

	@PostMapping("submit")
	public String submit() {
		return "in submit method";

	}

	@GetMapping("display1")
	public TestDTO display1() {
		
		TestDTO dto = new TestDTO();
		dto.setId(1L);
		dto.setFirstName("aditya");
		dto.setLastName("lastName");
		dto.setLoginId("aditya@gmail.com");
		dto.setPassword("adi@123");
		dto.setDob("12-01-2002");

		return dto;
	}

}

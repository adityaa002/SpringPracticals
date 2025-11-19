package in.co.rays.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		dto.setLastName("sharma");
		dto.setLoginId("aditya@gmail.com");
		dto.setPassword("adi@123");
		dto.setDob("12-01-2002");

		return dto;
	}

	@GetMapping("display2")
	public ORSResponse display2() {
		ORSResponse res = new ORSResponse();
		return res;
	}

	@GetMapping("display3")
	public ORSResponse display3() {

		ORSResponse res = new ORSResponse();

		Map error = new HashMap();

		error.put("fisrtName", "First Name is required..!");
		error.put("LastName", "Last Name is required..!");
		error.put("Login", "Login is required..!");
		error.put("Password", "Password is required..!");
		error.put("dob", "dob is required..!");

		res.addInputError(error);
		return res;
	}

	@GetMapping("display4")
	public ORSResponse display4() {

		ORSResponse res = new ORSResponse();
		TestDTO dto = new TestDTO();

		dto.setId(1L);
		dto.setFirstName("aditya");
		dto.setLastName("sharma");
		dto.setLoginId("aditya@gmail.com");
		dto.setPassword("adi@123");
		dto.setDob("12-01-2002");

		res.setSuccess(true);

		res.addData(dto);

		return res;

	}

	@GetMapping("display5")
	public ORSResponse display5() {

		ORSResponse rs = new ORSResponse();
		TestDTO dto1 = new TestDTO();

		dto1.setId(1L);
		dto1.setFirstName("aditya");
		dto1.setLastName("sharma");
		dto1.setLoginId("aditya@gmail.com");
		dto1.setPassword("adi@123");
		dto1.setDob("12-01-2002");

		TestDTO dto2 = new TestDTO();

		dto2.setId(2L);
		dto2.setFirstName("devansh");
		dto2.setLastName("sharma");
		dto2.setLoginId("deva11@gmail.com");
		dto2.setPassword("deww@123");
		dto2.setDob("14-11-2002");

		List list = new ArrayList();

		list.add(dto1);
		list.add(dto2);

		rs.setSuccess(true);

		rs.addData(list);

		return rs;

	}

	@GetMapping("display6")
	public ORSResponse display6() {

	}

}

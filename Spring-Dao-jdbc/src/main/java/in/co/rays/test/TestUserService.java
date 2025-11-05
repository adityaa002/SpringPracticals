package in.co.rays.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import in.co.rays.dto.UserDto;
import in.co.rays.service.UserServiceInt;

@Component("TestUserService")
public class TestUserService {

	@Autowired
	public UserServiceInt service;

	public static void main(String[] args) throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestUserService test = context.getBean(TestUserService.class);

		// test.testAdd();
		// test.testUpdate();
		// test.testDelete();
		// test.testFindByLogin();
		// test.testAuthenticate();
		test.testSearch();
	}

	public void testSearch() throws Exception {
		UserDto dto = new UserDto();

		dto.setFirstName("pqr");

		List<UserDto> list = service.search(1, 10, dto);

		Iterator it = list.iterator();

		while (it.hasNext()) {
			dto = (UserDto) it.next();
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		}
	}

	public void testAdd() throws Exception {
		UserDto dto = new UserDto();
		dto.setId(3);
		dto.setFirstName("def");
		dto.setLastName("xyz");
		dto.setLogin("admin112");
		dto.setPassword("123");
		long pk = service.add(dto);

		System.out.println("data inserted...! row affected : " + pk);

	}

	public void testUpdate() {
		UserDto dto = new UserDto();
		dto.setFirstName("pqr");
		dto.setLastName("xuv");
		dto.setLogin("admin22");
		dto.setPassword("pass123");
		dto.setId(1);
		service.update(dto);
		System.out.println("record updated");
	}

	public void testDelete() {
		UserDto dto = new UserDto();
		dto.setId(2);
		service.delete(dto);
		System.out.println("Record deleted");
	}

	public void testFindByLogin() {

		UserDto dto = service.findByLogin("admin");

		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("record not found...!");
		}
	}

	public void testAuthenticate() {
		UserDto dto = service.authenticate("admin", "pass123");

		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("Invalid Credentials...!");
		}
	}

}

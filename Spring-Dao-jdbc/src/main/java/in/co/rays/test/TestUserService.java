package in.co.rays.test;

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

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestUserService test = context.getBean(TestUserService.class);
		
		//test.testAdd();
		//test.testUpdate();
		test.testDelete();
		
	}

	public void testAdd() {
		UserDto dto = new UserDto();
		dto.setId(2);
		dto.setFirstName("abc");
		dto.setLastName("xyz");
		dto.setLogin("admin123");
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
}

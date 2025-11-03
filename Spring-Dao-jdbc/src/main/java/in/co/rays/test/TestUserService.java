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
		test.testAdd();
	}

	public void testAdd() {
 		UserDto dto = new UserDto();
		dto.setId(2);
		dto.setFirstName("abc");
		dto.setLastName("xyz");
		dto.setLogin("admin123");
		dto.setPassword("123");
		long pk = service.add(dto);
			
		System.out.println("data inserted...! record updated : " + pk);
			
		}
}

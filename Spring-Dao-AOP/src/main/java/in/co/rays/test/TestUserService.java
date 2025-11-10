package in.co.rays.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import in.co.rays.dto.UserDTO;
import in.co.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	public UserServiceInt userService = null;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestUserService service = (TestUserService) context.getBean("testUserService");
		
		
		service.testAdd();
//		service.testUpdate();
//		service.testDelete();
//		service.testFindByPk();
//		service.testFindByLogin();
//		service.testAuth();
//		service.testSearch();
	}

	private void testSearch() {
		// TODO Auto-generated method stub

	}

	private void testAuth() {
		// TODO Auto-generated method stub

	}

	private void testFindByLogin() {
		// TODO Auto-generated method stub

	}

	private void testFindByPk() {
		// TODO Auto-generated method stub

	}

	private void testDelete() {
		// TODO Auto-generated method stub

	}

	private void testUpdate() {
		// TODO Auto-generated method stub

	}

	private void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setId(4L);
		dto.setFirstName("aditya");
		dto.setLastName("sharma");
		dto.setLogin("aaeditya@gmail.com");
		dto.setPassword("pass123");

		userService.add(dto);
	}

}

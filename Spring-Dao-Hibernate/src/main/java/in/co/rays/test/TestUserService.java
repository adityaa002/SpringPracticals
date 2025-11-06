package in.co.rays.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import in.co.rays.dto.UserDTO;
import in.co.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	private UserServiceInt userDao;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService servcie = context.getBean(TestUserService.class);

		servcie.testAdd();

	}

	public void testAdd() {

		UserDTO dto = new UserDTO();
		dto.setFirstName("abc");
		dto.setLastName("xyz");
		dto.setLogin("admin");
		dto.setPassword("pass123");
		userDao.add(dto);

	}

}

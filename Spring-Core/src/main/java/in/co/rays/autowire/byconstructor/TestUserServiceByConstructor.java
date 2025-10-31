package in.co.rays.autowire.byconstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceByConstructor {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("autowire-by-constructor.xml");
		UserService user = context.getBean("userService", UserService.class);
		user.testAdd();
	}
}

package in.co.rays.autowire.bytype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceByType {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("autowire-by-type.xml");
		UserService userService = context.getBean("userService", UserService.class);
		userService.testAdd();
	}

}

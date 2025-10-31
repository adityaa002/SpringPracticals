package in.co.rays.autowire.byname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestUserServiceByName {
	
	public static void main(String[] args) {
	
		ApplicationContext context = new ClassPathXmlApplicationContext("autowire-by-name.xml");
		
		UserService service = (UserService) context.getBean("userService");
		
		service.testAdd();
	
	}

}

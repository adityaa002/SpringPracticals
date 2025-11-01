package in.co.rays.autowirebyannotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.co.rays.AppConfig;

public class TestUserServicebyAutowireAnnotation {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService service = context.getBean(UserService.class);

		service.testAdd();
	}
}

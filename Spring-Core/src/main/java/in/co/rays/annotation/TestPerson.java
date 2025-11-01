package in.co.rays.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.co.rays.AppConfig;

public class TestPerson {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		Person p = context.getBean("Person", Person.class);

		System.out.println("Name : " + p.getName());
		System.out.println("Address : " + p.getAddress());
	}

}

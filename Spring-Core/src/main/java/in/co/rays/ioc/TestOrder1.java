package in.co.rays.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.co.rays.lifecycle.MyBean;

public class TestOrder1 {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("order1.xml");
		Order1 order1 = context.getBean("order1", Order1.class);
		order1.bookATicket(4);
	}
}

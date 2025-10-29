package in.co.rays.lifecycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLifeCycle {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("lifecycle.xml");
		MyBean bean = context.getBean("MyBean", MyBean.class);
		bean.service();
		((ClassPathXmlApplicationContext) context).close();
	}

}

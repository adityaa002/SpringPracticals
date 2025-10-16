package in.co.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestEmployee {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("employee.xml"));
		Employee emp = (Employee) factory.getBean("employee");

		System.out.println("Name :" + emp.getName());
		System.out.println("Salary :" + emp.getSalary());

		Person p = (Person) factory.getBean("person");
		System.out.println("Name :" + p.getName());
		System.out.println("Address :" + p.getAddress());
	}

}

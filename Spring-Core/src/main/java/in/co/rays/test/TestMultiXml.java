package in.co.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestMultiXml {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("MultiXML.xml"));
		Person p = (Person) factory.getBean("person");

		System.out.println("Person's name : " + p.getName());
		System.out.println("Person's address : " + p.getAddress());

		System.out.println("----------------------------");
		
		Employee emp = (Employee) factory.getBean("employee");

		System.out.println("Name :" + emp.getName());
		System.out.println("Salary :" + emp.getSalary());
	}
}

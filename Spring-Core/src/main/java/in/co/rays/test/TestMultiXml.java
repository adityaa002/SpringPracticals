package in.co.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class TestMultiXml {

	public static void main(String[] args) {
		/*
		 * 
		 * BeanFactory factory = new XmlBeanFactory(new
		 * ClassPathResource("MultiXML.xml"));
		 * 
		 * // With typeCasting // Person p = (Person) factory.getBean("person");
		 * 
		 * // Without typeCasting Person p = factory.getBean("person", Person.class);
		 * 
		 * System.out.println("Person's name : " + p.getName());
		 * System.out.println("Person's address : " + p.getAddress());
		 * 
		 * System.out.println("----------------------------");
		 * 
		 * // With typeCasting // Employee emp = (Employee) factory.getBean("employee");
		 * 
		 * // Without typeCasting Employee emp = factory.getBean("employee",
		 * Employee.class);
		 * 
		 * System.out.println("Name :" + emp.getName()); System.out.println("Salary :" +
		 * emp.getSalary());
		 * 
		 */

		ApplicationContext context = new ClassPathXmlApplicationContext("MultiXML.xml");
		Person p = context.getBean("person", Person.class);
		System.out.println("Person's name : " + p.getName());
		System.out.println("Person's address : " + p.getAddress());

		System.out.println("----------------------------");

		Employee emp = context.getBean("employee", Employee.class);
		System.out.println("Name :" + emp.getName());
		System.out.println("Salary :" + emp.getSalary());

		System.out.println("----------------------------");

		Student st = context.getBean("student", Student.class);
		System.out.println("RollNo :" + st.getRollNo());
		System.out.println("Name :" + st.getName());

	}
}

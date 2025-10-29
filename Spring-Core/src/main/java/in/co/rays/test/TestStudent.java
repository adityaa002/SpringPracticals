package in.co.rays.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class TestStudent {

	public static void main(String[] args) {

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource("student.xml"));

		Student st = factory.getBean("student", Student.class);

		System.out.println("Student rollNo :" + st.getRollNo());
		System.out.println("Student's name :" + st.getName());
		
		

	}
}

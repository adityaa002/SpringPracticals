package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import in.co.rays.dto.UserDTO;
import in.co.rays.service.UserServiceInt;

public class TestUserDao {

	@Autowired
	private static UserServiceInt service;

	public static void main(String[] args) {
		testSearch();

	}

	private static void testSearch() {

		UserDTO dto = new UserDTO();

 		List list = service.search(dto, 1, 5);
		System.out.println("error traced");
		Iterator it = list.iterator();

		while (it.hasNext()) {
			dto = (UserDTO) it.next();
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + "\t" + dto.getLastName());
			System.out.print("\t" + "\t" + dto.getLogin());
			System.out.println("\t" + "\t" + dto.getPassword());
		}

	}

}

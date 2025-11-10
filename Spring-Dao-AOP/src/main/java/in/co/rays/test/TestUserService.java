package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import in.co.rays.dto.UserDTO;
import in.co.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	public UserServiceInt userService = null;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		TestUserService service = (TestUserService) context.getBean("testUserService");

//		service.testAdd();
//		service.testUpdate();
//		service.testDelete();
//		service.testFindByPk();
//		service.testFindByLogin();
//		service.testAuth();
		service.testSearch();
	}

	private void testSearch() {
		
		UserDTO dto = new UserDTO();

		dto.setFirstName("amit");
		
		List list = userService.search(dto, 1, 5);

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

	private void testAuth() {
		UserDTO dto = userService.authenticate("aditya@gmail.com", "pass123");
		if (dto != null) {
			System.out.print(dto.getId());
			System.out.print("\t" + dto.getFirstName());
			System.out.print("\t" + dto.getLastName());
			System.out.print("\t" + dto.getLogin());
			System.out.println("\t" + dto.getPassword());
		} else {
			System.out.println("user not found");
		}
	}

	private void testFindByLogin() {
		UserDTO dto = userService.findByLogin("aditya@gmail.com");
		System.out.print(dto.getId());
		System.out.print("\t" + dto.getFirstName());
		System.out.print("\t" + dto.getLastName());
		System.out.print("\t" + dto.getLogin());
		System.out.println("\t" + dto.getPassword());
	}

	private void testFindByPk() {

		UserDTO dto = userService.findBypk(5L);

		System.out.print(dto.getId());
		System.out.print("\t" + dto.getFirstName());
		System.out.print("\t" + dto.getLastName());
		System.out.print("\t" + dto.getLogin());
		System.out.println("\t" + dto.getPassword());
	}

	private void testDelete() {
		UserDTO dto = new UserDTO();
		dto.setId(4L);
		userService.delete(dto);
	}

	private void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("aadityaa");
		dto.setId(5);
		userService.update(dto);
	}

	private void testAdd() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("aditya");
		dto.setLastName("sharma");
		dto.setLogin("aaeditya@gmail.com");
		dto.setPassword("pass123");

		userService.add(dto);
	}

}

package in.co.rays.test;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import in.co.rays.dto.UserDTO;
import in.co.rays.service.UserServiceInt;

@Component("testUserService")
public class TestUserService {

	@Autowired
	private UserServiceInt userService;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService service = context.getBean(TestUserService.class);

//		 service.testAdd();
//		 service.testUpdate();
//		 service.testDelete();
//		 service.testFindByPk();
//		service.testFindByLogin();
//		service.testAuth();
//		service.testSearch();
	}

	private void testSearch() {

		UserDTO dto = null;
		List list = userService.search(dto, 0, 5);

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

	public void testAuth() {
		UserDTO dto = userService.authenticate("admin", "pass123");
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

		UserDTO dto = userService.findByLogin("admin12");
		System.out.print(dto.getId());
		System.out.print("\t" + dto.getFirstName());
		System.out.print("\t" + dto.getLastName());
		System.out.print("\t" + dto.getLogin());
		System.out.println("\t" + dto.getPassword());

	}

	private void testFindByPk() {
		UserDTO dto = userService.findByPk(3L);

		System.out.print(dto.getId());
		System.out.print("\t" + dto.getFirstName());
		System.out.print("\t" + dto.getLastName());
		System.out.print("\t" + dto.getLogin());
		System.out.println("\t" + dto.getPassword());

	}

	private void testDelete() {
		UserDTO dto = new UserDTO();
		dto.setId(2L);
		userService.delete(dto);
	}

	private void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("def");
		dto.setId(1);
		userService.update(dto);

	}

	public void testAdd() {

		UserDTO dto = new UserDTO();
		dto.setId(2L);
		dto.setFirstName("aditya");
		dto.setLastName("sharma");
		dto.setLogin("aditya@gmail.com");
		dto.setPassword("pass123");
		userService.add(dto);

	}

}

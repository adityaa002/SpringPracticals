package in.co.rays.test;

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
	private UserServiceInt userDao;

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		TestUserService service = context.getBean(TestUserService.class);

		// service.testAdd();
		// service.testUpdate();
		// service.testDelete();
		// service.testFindByPk();
		service.testFindByLogin();
	}

	private void testFindByLogin() {

		UserDTO dto = userDao.findByLogin("admin12");
		System.out.print(dto.getId());
		System.out.print("\t" + dto.getFirstName());
		System.out.print("\t" + dto.getLastName());
		System.out.print("\t" + dto.getLogin());
		System.out.println("\t" + dto.getPassword());
		
	}

	private void testFindByPk() {
		UserDTO dto = userDao.findByPk(3L);

		System.out.print(dto.getId());
		System.out.print("\t" + dto.getFirstName());
		System.out.print("\t" + dto.getLastName());
		System.out.print("\t" + dto.getLogin());
		System.out.println("\t" + dto.getPassword());

	}

	private void testDelete() {
		UserDTO dto = new UserDTO();
		dto.setId(2L);
		userDao.delete(dto);
	}

	private void testUpdate() {
		UserDTO dto = new UserDTO();
		dto.setFirstName("def");
		dto.setId(1);
		userDao.update(dto);

	}

	public void testAdd() {

		UserDTO dto = new UserDTO();
		// dto.setId(2L);
		dto.setFirstName("abc");
		dto.setLastName("xyz");
		dto.setLogin("admin");
		dto.setPassword("pass123");
		userDao.add(dto);

	}

}

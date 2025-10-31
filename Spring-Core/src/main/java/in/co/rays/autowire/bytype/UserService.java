package in.co.rays.autowire.bytype;

public class UserService {

	public UserDAOInt userDao; // property or dependency

	public void setUserDao(UserDAOInt userDao) {

		this.userDao = userDao;

	}

	public void testAdd() {
		userDao.add();
	}
}

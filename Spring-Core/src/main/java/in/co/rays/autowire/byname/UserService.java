package in.co.rays.autowire.byname;

public class UserService {
	
	public UserDAOInt userDao;

	public void setUserDao(UserDAOInt userDao) {
		this.userDao = userDao;
	}

	
	public void testAdd() {
		userDao.add();
	}

}

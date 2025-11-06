package in.co.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.dao.UserDAOInt;
import in.co.rays.dto.UserDTO;

@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserDAOInt userDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		return userDao.add(dto);
	}

	public void update(UserDTO dto) {
		// TODO Auto-generated method stub

	}

	public void delete(UserDTO dto) {
		// TODO Auto-generated method stub

	}

	public UserDTO findByPk(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDTO authenticate(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}

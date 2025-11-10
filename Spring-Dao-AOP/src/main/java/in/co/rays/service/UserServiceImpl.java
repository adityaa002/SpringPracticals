package in.co.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.co.rays.dao.UserDAOInt;
import in.co.rays.dto.UserDTO;

@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserDAOInt userDao = null;

	public long add(UserDTO dto) {
		return userDao.add(dto);
	}

	public void update(UserDTO dto) {
		userDao.update(dto);
	}

	public void delete(UserDTO dto) {
		userDao.delete(dto);
	}

	public UserDTO findBypk(long pk) {
		return userDao.findBypk(pk);
	}

	public UserDTO findByLogin(String login) {
		return userDao.findByLogin(login);
	}

	public UserDTO authenticate(String login, String password) {
		return userDao.authenticate(login, password);
	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		return userDao.search(dto, pageNo, pageSize);
	}

}

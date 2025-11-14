package in.co.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.dao.UserDaoInt;
import in.co.rays.dto.UserDTO;

@Service
@Transactional
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	private UserDaoInt userDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		// TODO Auto-generated method stub
		return userDao.add(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		userDao.update(dto);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(UserDTO dto) {
		userDao.delete(dto);

	}

	@Transactional(readOnly = true)
	public UserDTO findByPk(long id) {
		return userDao.findByPk(id);
	}

	public UserDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		return userDao.findByLogin(login);
	}

	public UserDTO authenticate(String login, String password) {
		// TODO Auto-generated method stub
		return userDao.authenticate(login, password);
	}

	@Transactional(readOnly = true)
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return userDao.search(dto, pageNo, pageSize);
	}

}

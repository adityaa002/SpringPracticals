package in.co.rays.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.co.rays.dao.UserDaoInt;
import in.co.rays.dto.UserDTO;

@Service
public class UserServiceImpl implements UserServiceInt {

	private UserDaoInt userDao;

	@Override
	public long add(UserDTO dto) {
		// TODO Auto-generated method stub
		return userDao.add(dto);
	}

	@Override
	public void update(UserDTO dto) {
		userDao.update(dto);
	}

	@Override
	public void delete(UserDTO dto) {
		userDao.delete(dto);

	}

	@Override
	public UserDTO findByPk(long id) {
		return userDao.findByPk(id);
	}

	@Override
	public UserDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		return userDao.findByLogin(login);
	}

	@Override
	public UserDTO authenticate(String login, String password) {
		// TODO Auto-generated method stub
		return userDao.authenticate(login, password);
	}

	@Override
	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return userDao.search(dto, pageNo, pageSize);
	}

}

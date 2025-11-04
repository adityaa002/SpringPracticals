package in.co.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.dao.UserDaoInt;
import in.co.rays.dto.UserDto;

@Service
public class UserServiceImpl implements UserServiceInt {

	@Autowired
	public UserDaoInt dao;

	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDto dto) throws Exception {
		long pk = dao.add(dto);
		return pk;

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDto dto) {
		dao.update(dto);

	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(UserDto dto) {
		dao.delete(dto);
	}

	public UserDto findByLogin(String login) {
		return dao.findByLogin(login);
	}

	public UserDto authenticate(String login, String password) {
		return dao.authenticate(login, password);
	}
}

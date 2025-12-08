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
	public UserDaoInt userDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long add(UserDTO dto) {
		return userDao.add(dto);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(UserDTO dto) {
		userDao.update(dto);
	}

	@Override
	@Transactional(readOnly = true)
	public UserDTO findByPk(long id) {
		return userDao.findByPk(id);
	}

	@Override
	@Transactional(readOnly = true)

	public List search(UserDTO dto, int pageNo, int pageSize) {
		List list = userDao.search(dto, pageNo, pageSize);
		return list;
	}

	@Override
	public void delete(long id) {
		UserDTO dto = userDao.findByPk(id);
		userDao.delete(dto);
	}

	@Override
	public UserDTO authenticate(String loginId, String password) {
		UserDTO dto = userDao.findByUniqueKey("loginId", loginId);

		if (dto != null) {
			if (dto.getPassword().equals(password)) {
				return dto;
			}
		}

		return null;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public long save(UserDTO dto) {
		Long id = dto.getId();
		if (id != null && id > 0) {
			update(dto);
		} else {
			id = add(dto);
		}
		return id;
	}
}

package in.co.rays.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.dao.RoleDaoInt;
import in.co.rays.dto.RoleDTO;

@Service
@Transactional
public class RoleServiceImpl implements RoleServiceInt {

	@Autowired
	public RoleDaoInt roleDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long add(RoleDTO dto) {
		return roleDao.add(dto);

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(RoleDTO dto) {
		roleDao.update(dto);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		RoleDTO dto = findByPk(id);
		roleDao.delete(dto);
	}

	@Override
	@Transactional(readOnly = true)
	public RoleDTO findByPk(long id) {
		return roleDao.findByPk(id);
	}

	@Override
	public List search(RoleDTO dto, int pageNo, int pageSize) {
		return roleDao.search(dto, pageSize, pageNo);
	}

}

package in.co.rays.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import in.co.rays.dao.AttatchmentDaoInt;
import in.co.rays.dto.AttatchmentDTO;

@Service
@Transactional
public class AttatchmentServiceImpl implements AttatchmentServiceInt {

	@Autowired
	public AttatchmentDaoInt attatchmentDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long add(AttatchmentDTO dto) {

		return attatchmentDao.add(dto);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(AttatchmentDTO dto) {
		attatchmentDao.update(dto);
	}

	@Override
	public void delete(long id) {
		AttatchmentDTO dto = findByPk(id);
		attatchmentDao.delete(dto);
	}

	@Override
	@Transactional(readOnly = true)
	public AttatchmentDTO findByPk(long id) {
		return attatchmentDao.findByPk(id);
	}

}

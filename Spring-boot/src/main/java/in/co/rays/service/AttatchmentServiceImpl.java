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

		long pk = attatchmentDao.add(dto);
		
		return pk;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(AttatchmentDTO dto) {
		attatchmentDao.update(dto);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void delete(long id) {
		try {
		
		AttatchmentDTO dto = findByPk(id);
		attatchmentDao.delete(dto);
		
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public AttatchmentDTO findByPk(long id) {
		AttatchmentDTO dto = attatchmentDao.findByPk(id);
		return dto;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public long save(AttatchmentDTO dto) {
		Long id = dto.getId();
		if (id != null && id > 0) {
			update(dto);
		} else {
			id = add(dto);
		}
		return id;
	}


}

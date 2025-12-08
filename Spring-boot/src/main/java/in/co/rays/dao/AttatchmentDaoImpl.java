package in.co.rays.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import in.co.rays.dto.AttatchmentDTO;

@Repository
public class AttatchmentDaoImpl implements AttatchmentDaoInt {

	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public long add(AttatchmentDTO dto) {
		entityManager.persist(dto);
		return dto.getId();

	}

	@Override
	public void update(AttatchmentDTO dto) {
		entityManager.merge(dto);
	}

	@Override
	public void delete(AttatchmentDTO dto) {
		entityManager.remove(dto);
	}

	@Override
	public AttatchmentDTO findByPk(long id) {
		 AttatchmentDTO dto = entityManager.find(AttatchmentDTO.class, id);
		return dto;
	}

}

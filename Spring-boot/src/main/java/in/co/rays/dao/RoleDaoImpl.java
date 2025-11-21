package in.co.rays.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import in.co.rays.dto.RoleDTO;

@Repository
public class RoleDaoImpl implements RoleDaoInt {

	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public long add(RoleDTO dto) {

		entityManager.persist(dto); // Add
		return dto.getId();

	}

	@Override
	public void update(RoleDTO dto) {

		entityManager.merge(dto); // update

	}

	@Override
	public void delete(RoleDTO dto) {

		entityManager.remove(dto);

	}

	@Override
	public RoleDTO findByPk(long pk) {

		RoleDTO dto = entityManager.find(RoleDTO.class, pk);

		return dto;
	}

}

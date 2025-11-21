package in.co.rays.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import in.co.rays.dto.RoleDTO;

public class RoleDaoImpl implements RoleDaoInt {

	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public long add(RoleDTO dto) {
		
		entityManager.persist(dto);
		return dto.getId();
		
	}

	@Override
	public void update(RoleDTO dto) {

	}

	@Override
	public void delete(RoleDTO dto) {

	}

	@Override
	public RoleDTO findByPk(long id) {

		return null;
	}

}

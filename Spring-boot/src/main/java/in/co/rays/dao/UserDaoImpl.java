package in.co.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import in.co.rays.dto.UserDTO;


@Repository
public class UserDaoImpl implements UserDaoInt {

	@PersistenceContext
	public EntityManager entityManager;

	@Override
	public long add(UserDTO dto) {
		entityManager.persist(dto);
		return dto.getId();
	}

	@Override
	public void update(UserDTO dto) {
		entityManager.merge(dto);

	}

	@Override
	public void delete(UserDTO dto) {
		entityManager.remove(dto);
	}

	@Override
	public UserDTO findByPk(long id) {
		UserDTO dto = entityManager.find(UserDTO.class, id);
		return dto;
	}

	@Override
	public List search(UserDTO dto, int pageNo, int pageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery cq = builder.createQuery(UserDTO.class);

		Root<UserDTO> qRoot = cq.from(UserDTO.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto != null) {

			if (dto.getFirstName() != null && dto.getFirstName().length() > 0) {

				predicateList.add(builder.like(qRoot.get("firstName"), dto.getFirstName() + "%"));
			}
			if (dto.getLoginId() != null && dto.getLoginId().length() > 0) {

				predicateList.add(builder.like(qRoot.get("login"), dto.getLoginId() + "%"));
			}
			if (dto.getDob() != null) {

				predicateList.add(builder.like(qRoot.get("date"), dto.getDob() + "%"));
			}

			if (dto.getRoleId() != 0 && dto.getRoleId().SIZE > 0) {

				predicateList.add(builder.like(qRoot.get("roleId"), dto.getRoleId() + "%"));
			}
			if (dto.getRoleName() != null && dto.getRoleName().length() > 0) {

				predicateList.add(builder.like(qRoot.get("roleName"), dto.getRoleName() + "%"));
			}

		}

		cq.where(predicateList.toArray(new Predicate[predicateList.size()]));

		TypedQuery<UserDTO> tq = entityManager.createQuery(cq);

		if (pageSize > 0) {
			tq.setFirstResult(pageNo * pageSize);
			tq.setMaxResults(pageSize);
		}

		List<UserDTO> list = tq.getResultList();
		return list;
	}

}

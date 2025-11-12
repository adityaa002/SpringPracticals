package in.co.rays.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.rays.dto.UserDTO;

@Repository
public class UserDaoImpl implements UserDaoInt {

	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public long add(UserDTO dto) {
		Session session = sessionFactory.getCurrentSession();
		long pk = (long) session.save(dto);
		return pk;
	}

	@Override
	public void update(UserDTO dto) {
		Session session = sessionFactory.getCurrentSession();
		if (dto.getId() > 0) {
			session.update(dto);
		} else {
			session.saveOrUpdate(dto);
		}
	}

	@Override
	public void delete(UserDTO dto) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(dto);

	}

	@Override
	public UserDTO findByPk(long id) {

		Session session = sessionFactory.getCurrentSession();
		UserDTO dto = session.get(UserDTO.class, id);

		return dto;
	}

	@Override
	public UserDTO findByLogin(String login) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.like("login", login));

		UserDTO dto = null;
		List list = criteria.list();

		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);
		}
		return dto;
	}

	@Override
	public UserDTO authenticate(String login, String password) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(UserDTO.class);

		criteria.add(Restrictions.like("login", login));
		criteria.add(Restrictions.like("password", password));

		UserDTO dto = null;
		List list = criteria.list();

		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);
		}
		return dto;
	}

}

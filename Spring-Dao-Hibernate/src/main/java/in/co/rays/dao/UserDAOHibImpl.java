package in.co.rays.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.rays.dto.UserDTO;

@Repository
public class UserDAOHibImpl implements UserDAOInt {

	@Autowired
	private SessionFactory sessionFactory = null;

	public long add(UserDTO dto) {

		Session session = sessionFactory.getCurrentSession();
		long pk = (Long) session.save(dto);

		return pk;
	}

	public void update(UserDTO dto) {
		Session session = sessionFactory.getCurrentSession();
		session.update(dto);

	}

	public void delete(UserDTO dto) {

		Session session = sessionFactory.getCurrentSession();
		session.delete(dto);
	}

	public UserDTO findByPk(long id) {
		Session session = sessionFactory.getCurrentSession();
		UserDTO dto = session.get(UserDTO.class, id);
		return dto;
	}

	public UserDTO findByLogin(String login) {
		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("login", login));

		List list = criteria.list();

		UserDTO dto = null;

		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);
		}

		return dto;

	}

	public UserDTO authenticate(String login, String password) {

		Session session = sessionFactory.getCurrentSession();

		List list = null;
		UserDTO dto = null;

		Criteria criteria = session.createCriteria(UserDTO.class);
		criteria.add(Restrictions.eq("login", login));
		criteria.add(Restrictions.eq("password", password));

		list = criteria.list();

		if (list.size() > 0) {
			dto = (UserDTO) list.get(0);
		}

		return dto;
	}

	public List search(UserDTO dto, int pageNo, int pageSize) {

		Session session = sessionFactory.getCurrentSession();

		Criteria criteria = session.createCriteria(UserDTO.class);

		return null;
	}

}

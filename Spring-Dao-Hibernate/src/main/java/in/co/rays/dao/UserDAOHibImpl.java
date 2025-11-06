package in.co.rays.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import in.co.rays.dto.UserDTO;

public class UserDAOHibImpl implements UserDAOInt {

	@Autowired
	private SessionFactory sessionFactory = null;

	public long add(UserDTO dto) {

		Session session = sessionFactory.getCurrentSession();
		long pk = (Long) session.save(dto);

		return 0;
	}

}

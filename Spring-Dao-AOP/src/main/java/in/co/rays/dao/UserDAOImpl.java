package in.co.rays.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import in.co.rays.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAOInt {

	@Autowired
	public SessionFactory sessionFactory = null;

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

	public UserDTO findBypk(long id) {

		Session session = sessionFactory.getCurrentSession();

		UserDTO dto = session.get(UserDTO.class, id);

		return dto;
	}

	public UserDTO findByLogin() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserDTO findByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

}

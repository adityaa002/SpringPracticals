package in.co.rays.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import in.co.rays.dto.UserDto;

@Repository
public class UserDaoJdbcImpl implements UserDaoInt {

	public JdbcTemplate jdbcTemplate;

	public DataSource dataSource = null;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public long add(UserDto dto) throws Exception {

		UserDto existDto = findByLogin(dto.getLogin());
		if (existDto != null) {
			throw new Exception("record already exist..!");
		}

		String sql = "insert into st_user values(?,?,?,?,?)";
		int pk = jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(),
				dto.getPassword());
		return pk;
	}

	public void update(UserDto dto) {
		String sql = "update st_user set firstName = ? , lastName = ? , login = ? , password = ?  where id = ?";
		int pk = jdbcTemplate.update(sql, dto.getFirstName(), dto.getLastName(), dto.getLogin(), dto.getPassword(),
				dto.getId());

	}

	public void delete(UserDto dto) {
		String sql = "delete from st_user where id = ?";
		jdbcTemplate.update(sql, dto.getId());
	}

	public UserDto findByLogin(String login) {
		String sql = "select id, firstName , lastName , login , password from st_user where login = ?";
		UserDto dto = null;
		try {
			Object[] param = { login };
			dto = jdbcTemplate.queryForObject(sql, param, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return dto;
	}

	public UserDto authenticate(String login, String password) {
		String sql = "select id, firstName , lastName , login , password from st_user where login = ? and password = ?";
		UserDto dto = null;
		try {
			Object[] param = { login , password };
			dto = jdbcTemplate.queryForObject(sql, param, new UserMapper());
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return dto;
	}

}

package in.co.rays.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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

	public long add(UserDto dto) {
		String sql = "insert into st_user values(?,?,?,?,?)";
		int pk = jdbcTemplate.update(sql, dto.getId(), dto.getFirstName(), dto.getLastName(), dto.getLogin(),
				dto.getPassword());
 		return pk;
	}

}

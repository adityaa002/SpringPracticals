package in.co.rays.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.co.rays.dto.UserDto;

public class UserMapper implements RowMapper<UserDto> {

	public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDto dto = new UserDto();
		dto.setId(rs.getLong(1));
		dto.setFirstName(rs.getString(2));
		dto.setLastName(rs.getString(3));
		dto.setLogin(rs.getString(4));
		dto.setPassword(rs.getString(5));
		return null;
	}

}

package in.co.rays.dao;

import in.co.rays.dto.UserDto;

public interface UserDaoInt {
	
	public long add(UserDto dto);

	public void update(UserDto dto);
	
	public void delete(UserDto dto);
	
}

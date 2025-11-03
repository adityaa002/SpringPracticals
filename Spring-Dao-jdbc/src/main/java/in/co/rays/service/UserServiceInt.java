package in.co.rays.service;

import in.co.rays.dto.UserDto;

public interface UserServiceInt {

	public long add(UserDto dto);

	public void update(UserDto dto);
	
	public void delete(UserDto dto);

}

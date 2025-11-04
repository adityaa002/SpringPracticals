package in.co.rays.dao;

import in.co.rays.dto.UserDto;

public interface UserDaoInt {

	public long add(UserDto dto) throws Exception;

	public void update(UserDto dto);

	public void delete(UserDto dto);

	public UserDto findByLogin(String login);

	public UserDto authenticate(String login, String password);

}

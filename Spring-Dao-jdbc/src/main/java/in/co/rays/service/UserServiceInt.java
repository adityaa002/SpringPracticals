package in.co.rays.service;

import java.util.List;

import in.co.rays.dto.UserDto;

public interface UserServiceInt {

	public long add(UserDto dto) throws Exception;

	public void update(UserDto dto);

	public void delete(UserDto dto);

	public UserDto findByLogin(String login);

	public UserDto authenticate(String login, String password);

	public List<UserDto> search(int pageNo, int pageSize, UserDto dto) throws Exception;

}

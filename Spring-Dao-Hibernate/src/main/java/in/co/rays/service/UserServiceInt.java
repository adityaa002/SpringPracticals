package in.co.rays.service;

import in.co.rays.dto.UserDTO;

public interface UserServiceInt {

	public long add(UserDTO dto);

	public void update(UserDTO dto);

	public void delete(UserDTO dto);

	public UserDTO findByPk(long id);

	public UserDTO findByLogin(String login);

	public UserDTO authenticate(String login, String password);

}

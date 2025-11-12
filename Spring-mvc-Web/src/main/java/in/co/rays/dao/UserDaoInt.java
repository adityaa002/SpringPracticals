package in.co.rays.dao;

import java.util.List;

import in.co.rays.dto.UserDTO;

public interface UserDaoInt {

	public long add(UserDTO dto);

	public void update(UserDTO dto);

	public void delete(UserDTO dto);

	public UserDTO findByPk(long id);

	public UserDTO findByLogin(String login);

	public UserDTO authenticate(String login, String password);

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize);

}

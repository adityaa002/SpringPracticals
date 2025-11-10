package in.co.rays.dao;

import java.util.List;

import in.co.rays.dto.UserDTO;

public interface UserDAOInt {

	public long add(UserDTO dto);

	public void update(UserDTO dto);

	public void delete(UserDTO dto);

	public UserDTO findBypk(long pk);

	public UserDTO findByLogin(String login);

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize);
}

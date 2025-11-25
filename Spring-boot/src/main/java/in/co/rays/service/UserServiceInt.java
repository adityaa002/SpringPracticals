package in.co.rays.service;

import java.util.List;

import in.co.rays.dto.UserDTO;

public interface UserServiceInt {

	public long add(UserDTO dto);

	public void update(UserDTO dto);

	public void delete(long id);

	public UserDTO findByPk(long id);

	public List search(UserDTO dto, int pageNo, int pageSize);

	public UserDTO authenticate(String loginId, String password);

}

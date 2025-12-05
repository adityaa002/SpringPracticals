package in.co.rays.dao;

import java.util.List;

import in.co.rays.dto.UserDTO;

public interface UserDaoInt {

	public long add(UserDTO dto);

	public void populate(UserDTO dto);

	public void update(UserDTO dto);

	public void delete(UserDTO dto);

	public UserDTO findByPk(long id);

	public List search(UserDTO dto, int pageNo, int pageSize);

	public UserDTO findByUniqueKey(String attribute, String value);

}

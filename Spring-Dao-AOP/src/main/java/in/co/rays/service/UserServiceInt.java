package in.co.rays.service;

import java.util.List;

import org.springframework.stereotype.Service;

import in.co.rays.dto.UserDTO;

 public interface UserServiceInt {

	public long add(UserDTO dto);

	public void update(UserDTO dto);

	public void delete(UserDTO dto);

	public UserDTO findBypk(long pk);

	public UserDTO findByLogin(String login);

	public UserDTO authenticate(String login, String password);

	public List<UserDTO> search(UserDTO dto, int pageNo, int pageSize);
}

package in.co.rays.service;

import java.util.List;

import in.co.rays.dto.RoleDTO;

public interface RoleServiceInt {

	public long add(RoleDTO dto);

	public void update(RoleDTO dto);

	public void delete(long id);

	public RoleDTO findByPk(long id);

	public List search(RoleDTO dto, int pageNo, int pageSize);
}

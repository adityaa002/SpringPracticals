package in.co.rays.dao;

import java.util.List;

import in.co.rays.dto.RoleDTO;

public interface RoleDaoInt {

	public long add(RoleDTO dto);

	public void update(RoleDTO dto);

	public void delete(RoleDTO dto);

	public RoleDTO findByPk(long id);

	public List search(RoleDTO dto, int pageNo, int pageSize);
}

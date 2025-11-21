package in.co.rays.dao;

import in.co.rays.dto.RoleDTO;

public interface RoleDaoInt {

	public long add(RoleDTO dto);

	public void update(RoleDTO dto);

	public void delete(RoleDTO dto);

	public RoleDTO findByPk(long id);

}

package in.co.rays.service;

import in.co.rays.dto.RoleDTO;

public interface RoleServiceInt {

	public long add(RoleDTO dto);

	public void update(RoleDTO dto);

	public void delete(RoleDTO dto);

	public RoleDTO findByPk(long id);
	
}

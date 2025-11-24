package in.co.rays.dao;

import in.co.rays.dto.AttatchmentDTO;

public interface AttatchmentDaoInt {
	
	public long add(AttatchmentDTO dto);

	public void update(AttatchmentDTO dto);

	public void delete(AttatchmentDTO dto);

	public AttatchmentDTO findByPk(long id);
}

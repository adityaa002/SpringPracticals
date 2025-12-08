package in.co.rays.service;

import in.co.rays.dto.AttatchmentDTO;

public interface AttatchmentServiceInt {
	
	public long add(AttatchmentDTO dto);

	public void update(AttatchmentDTO dto);

	public void delete(long id);

	public AttatchmentDTO findByPk(long id);
	
	public long save(AttatchmentDTO dto);

}

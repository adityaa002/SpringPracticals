package in.co.rays.form;

import javax.validation.constraints.NotEmpty;

import in.co.rays.common.BaseDTO;
import in.co.rays.common.BaseForm;
import in.co.rays.dto.RoleDTO;

public class RoleForm extends BaseForm {

	@NotEmpty(message = "RoleName is required")
	private String name;

	@NotEmpty(message = "Description is required")
	private String description;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public BaseDTO getDto() {

		RoleDTO dto = (RoleDTO) initDTO(new RoleDTO());

		dto.setName(name);
		dto.setDescription(description);
		return dto;

	}

}

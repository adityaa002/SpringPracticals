package in.co.rays.form;

import javax.validation.constraints.NotEmpty;

import in.co.rays.common.BaseDTO;
import in.co.rays.common.BaseForm;
import in.co.rays.dto.UserDTO;

public class LoginForm extends BaseForm {

	@NotEmpty(message = "LoginId is required !")
	private String loginId;

	@NotEmpty(message = "Password is required !")
	private String password;

	 

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
@Override
public BaseDTO getDto() {
	
	UserDTO dto = new UserDTO();
	dto.setLoginId(loginId);
	dto.setPassword(password);
	
	return dto;
}

public String getLoginId() {
	return loginId;
}

public void setLoginId(String loginId) {
	this.loginId = loginId;
}
}

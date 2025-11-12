package in.co.rays.form;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import in.co.rays.dto.UserDTO;

public class UserRegistrationForm {

	private long id;

	private String firstName;

	private String lastName;

	private String login;

	private String password;

	private String address;

}

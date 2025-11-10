package in.co.rays.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "ST_USER")
public class UserDTO {

	@Id
	@GeneratedValue(generator = "ncsPK")
	@GenericGenerator(name = "ncsPK", strategy = "native")
	@Column(name = "ID", unique = true, nullable = false)
	private long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "LOGIN")
	private String login;

	@Column(name = "PASSWORD")
	private String password;

}

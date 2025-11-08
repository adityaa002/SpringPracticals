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
	private String firstName;
	private String lastName;
	private String login;
	private String password;

}

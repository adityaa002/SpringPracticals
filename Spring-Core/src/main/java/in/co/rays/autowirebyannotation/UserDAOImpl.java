package in.co.rays.autowirebyannotation;

import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAOInt {

	public void add() {
		System.out.println("Add method by autowire Annotaion");
	}

}

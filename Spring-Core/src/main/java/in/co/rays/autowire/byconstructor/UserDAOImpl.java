package in.co.rays.autowire.byconstructor;

public class UserDAOImpl implements UserDAOInt {

	public void add() {
		System.out.println("add method called by constructor autowiring");
	}

}

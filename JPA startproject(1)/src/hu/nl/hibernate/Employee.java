package hu.nl.hibernate;

public class Employee {
	private int id;
	private String firstName, lastName;

	public Employee(){
		
	};
	
	public Employee(int i, String f, String l) {
		id = i;
		firstName =f;
		lastName = l;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
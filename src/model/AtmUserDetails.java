package model;

public class AtmUserDetails {
	
	//data members
	String username;
	String password;
	String mobileno;

	String firstName;
	String lastName;
	String location;
	String role;

	
	public AtmUserDetails(String username, String password, String mobileno, String firstName, String lastName,
			String location, String role) {
		super();
		this.username = username;
		this.password = password;
		this.mobileno = mobileno;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.role = role;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
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


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public AtmUserDetails() {
		super();
	}


	//getters and setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileno() {
		return mobileno;
	}
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	}




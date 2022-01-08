package model;

public class Admin {

	int cust_Id;
	String fullname;
	String location;
	int accountno;
	public int getCust_Id() {
		return cust_Id;
	}
	public void setCust_Id(int cust_Id) {
		this.cust_Id = cust_Id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public Admin(int cust_Id, String fullname, String location, int accountno) {
		super();
		this.cust_Id = cust_Id;
		this.fullname = fullname;
		this.location = location;
		this.accountno = accountno;
	}
	
	public Admin()
	{
		
	}
	
}

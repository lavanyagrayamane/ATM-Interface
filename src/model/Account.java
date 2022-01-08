package model;

public class Account {
	
	
	int accountno;
	int amount;
	int username;
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getUsername() {
		return username;
	}
	public void setUsername(int username) {
		this.username = username;
	}
	public Account(int accountno, int amount, int username) {
		super();
		this.accountno = accountno;
		this.amount = amount;
		this.username = username;
	}
	
	public Account()
	{
		
	}
	

}

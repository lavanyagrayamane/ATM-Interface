package dao;

import model.Account;

public interface AccountDao {
	
	public boolean deposit(int accountno,int amt);
	public boolean withdraw(int accountno,int amt);
	public int balance(int accountno);

}

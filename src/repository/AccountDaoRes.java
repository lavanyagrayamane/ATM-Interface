package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import config.MyConnection;
import model.Account;

public class AccountDaoRes {
	
	
	Connection connection=null;
	Statement statement=null;
	ResultSet resultSet=null;
	public AccountDaoRes() throws SQLException
	{
		connection=MyConnection.getConnection();
		statement=connection.createStatement();
	}
	
	
	public boolean deposit(int accountno,int amt) throws SQLException
	{

		ResultSet rs=statement.executeQuery("select * from account where accountno="+accountno+"");
		while(rs.next())
		{
		int balance=rs.getInt("amount");
		balance=balance+amt;
		int r1=statement.executeUpdate("update account set amount="+balance+"  where accountno="+accountno+" ");
		if(r1==1)
			return true;
		}
		return false;
		
	}
	
	 public boolean withdraw(int accountno,int amt) throws SQLException
	 {
	
		 ResultSet res=statement.executeQuery("select * from account where accountno="+accountno+"");
			while(res.next())
			{
			int balance=res.getInt("amount");
			if(balance>amt)
			{
			balance=balance-amt;
			int r1=statement.executeUpdate("update account set amount="+balance+"  where accountno="+accountno+" ");
			if(r1==1)
				return true;
			}
			}
				System.out.println("Insufficient Balance!!");
			return false;
			
	 }
	
	public  int balance(int accountno) throws SQLException
	{
		ResultSet rs2=statement.executeQuery("select * from account where accountno="+accountno+"");
		    rs2.next();
			int value=rs2.getInt("amount");
		
			//System.out.println("!!!!"+value);
			return value;
			
	
		
	}
}

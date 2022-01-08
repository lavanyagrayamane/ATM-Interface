package daoimpl;

import java.sql.SQLException;

import dao.AccountDao;
import model.Account;
import repository.AccountDaoRes;
import repository.AtmLoginDetailsDaoRes;

public class AccountDaoImpl implements AccountDao {
	
	AccountDaoRes accountDaoRes=null;
	
	public AccountDaoImpl()
	{
		try {
			accountDaoRes=new AccountDaoRes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in account repository"+e.getMessage());
		}
	}
	

	@Override
	public boolean deposit( int accountno,int amt) {
		// TODO Auto-generated method stub
		
		try {
			return accountDaoRes.deposit(accountno,amt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in deposit implementation"+ " " +e.getMessage());
			return false;
		}
	}

	@Override
	public boolean withdraw( int accountno,int amt) {
		// TODO Auto-generated method stub
		
		try {
			return accountDaoRes.withdraw(accountno,amt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in withdraw implementation"+ " " +e.getMessage());
			return false;
		}
	
	}

	@Override
	public int balance(int accountno) {
		// TODO Auto-generated method stub
		try {
			return accountDaoRes.balance(accountno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in balance implementation"+" "+e.getMessage());
			return 0;
			
		}
	}


}

package daoimpl;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.AdminDao;
import model.Admin;
import repository.AdminDaoRes;
public class AdminDaoImpl implements AdminDao{
	
        AdminDaoRes adminDaoRes=null;
	
	public AdminDaoImpl()
	{
		try {
			adminDaoRes=new AdminDaoRes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in account repository"+e.getMessage());
		}
	}
	

	@Override
	public boolean addUsers(Admin admin) {
		// TODO Auto-generated method stub
		try {
			return adminDaoRes.addUsers(admin);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in addUsers"+ " "+ e.getMessage());
			return false;
		}
	}

	


	@Override
	public boolean deleteUser(int cust_id) {
		return adminDaoRes.delteUser(cust_id);
	}


	@Override
	public ArrayList<Admin> allUsers() {
		return adminDaoRes.allUsers();
	}


	
}

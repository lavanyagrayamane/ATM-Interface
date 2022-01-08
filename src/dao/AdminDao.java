package dao;



import java.util.ArrayList;

import model.Admin;

public interface AdminDao {
	public boolean addUsers(Admin admin);
	public boolean deleteUser(int cust_id);
	public ArrayList<Admin> allUsers();
 
}

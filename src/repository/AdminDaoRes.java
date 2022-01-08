package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import config.MyConnection;
import model.Admin;

public class AdminDaoRes {
	
	Connection connection=null;
	Statement statement=null;
	ResultSet resultSet=null;
	public AdminDaoRes() throws SQLException
	{
		connection=MyConnection.getConnection();
		statement=connection.createStatement();
	}

	
	public boolean addUsers(Admin admin) throws SQLException
	{
		int adm=statement.executeUpdate("insert into Admin values("+admin.getCust_Id()+",'"+admin.getFullname()+"','"+admin.getLocation()+"','"+admin.getAccountno()+"')");
		if(adm==1)
		{
		return true;
		}else
			return false;

		}
	
	public boolean delteUser(int cust_id)
	{
		try{
	           int res=statement.executeUpdate("delete from admin where cust_Id="+cust_id+"");
	           if(res==1)
	           {
	    	       return true;
	            }else
	             {
	    	       System.out.println("Customer id is not found");
	    	         return false;
	              }  
	     }catch(SQLException e)
		{
	    	System.out.println(e.getMessage());
	    	return false;
		}
			
	}
	
	
	public ArrayList<Admin> allUsers() {
		// TODO Auto-generated method stub
			
			ArrayList<Admin> arrayList=new ArrayList<Admin>();
			ResultSet resultSet=null;
		     try{
				 resultSet=statement.executeQuery("select *from Admin");
				while(resultSet.next())
				{
					Admin user=new Admin();
					user.setCust_Id(resultSet.getInt("cust_Id"));
					user.setFullname(resultSet.getString("fullname"));
					user.setLocation(resultSet.getString("location"));
					user.setAccountno(resultSet.getInt("accountno"));
		
					arrayList.add(user);
					
				}
		
				return arrayList;
				}catch(SQLException e)
				{
					e.printStackTrace();
				}

			return null;
	}
}
	

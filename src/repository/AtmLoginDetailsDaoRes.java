package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;


import config.MyConnection;
import model.AtmUserDetails;

public class AtmLoginDetailsDaoRes {


		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		public AtmLoginDetailsDaoRes() throws SQLException
		{
			connection=MyConnection.getConnection();
			statement=connection.createStatement();
		}
		
		public boolean signUp(AtmUserDetails user) throws SQLException {
			// TODO Auto-generated method stub
		
		int r=statement.executeUpdate("insert into Userdetails values('"+user.getFirstName()+"','"+user.getLastName()+"','"+user.getLocation()+"','"+user.getMobileno()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getRole()+"')");
		if(r==1)
		{
		return true;
		}else
			return false;

		}
		public boolean signIn(AtmUserDetails user) throws SQLException {
			// TODO Auto-generated method stub
			
			
			String tuser=user.getUsername();
			String pass=user.getPassword();
			String trole=user.getRole();
			resultSet=statement.executeQuery("select *from Userdetails where username='"+tuser+"' and password='"+pass+"'and role='"+trole+"'");
			if(resultSet.next())
			{
			return true;
			}else
				return false;
		}

		
		
}


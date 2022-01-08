package dao;

import java.util.ArrayList;

import model.AtmUserDetails;

public interface AtmLoginDetailsDao {
	
	public boolean signUp(AtmUserDetails user);
	public boolean signIn(AtmUserDetails user);
	

}


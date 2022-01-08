package daoimpl;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import dao.AtmLoginDetailsDao;
import model.AtmUserDetails;
import repository.AtmLoginDetailsDaoRes;

public class AtmLoginDetailsDaoImpl implements AtmLoginDetailsDao{

	
	AtmLoginDetailsDaoRes loginDetailsDaoRes=null;
	
	public AtmLoginDetailsDaoImpl()
	{
		try {
			loginDetailsDaoRes=new AtmLoginDetailsDaoRes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in repository"+e.getMessage());
		}
	}
	
	

	@Override
	public boolean signUp(AtmUserDetails user) {
		// TODO Auto-generated method stub
		
		try {
			return loginDetailsDaoRes.signUp(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("problem in sign up"+e.getMessage());
			return false;
	}
	}

	@Override
	public boolean signIn(AtmUserDetails user) {
		// TODO Auto-generated method stub
		
		try {
			 
				return loginDetailsDaoRes.signIn(user);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;

	}
	}
	
    public static boolean isValidUsername(String name)
    {
    	String regex = "^(.+)@(.+)$";
    	Pattern p=Pattern.compile(regex);
    	if(name==null){
		return false;
    	}
    	
    	Matcher m=p.matcher(name);
    	return m.matches();
    }
    
    public static boolean isValidPwd(String pwd)
    {
    	String regex="^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
    	Pattern p=Pattern.compile(regex);
    	if(pwd==null){
		return false;
    	}
    	
    	Matcher m=p.matcher(pwd);
    	return m.matches();
    }
	

}



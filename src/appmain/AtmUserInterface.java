package appmain;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


import dao.AtmLoginDetailsDao;
import daoimpl.AccountDaoImpl;
import daoimpl.AdminDaoImpl;
import daoimpl.AtmLoginDetailsDaoImpl;
import model.Account;
import model.Admin;
import model.AtmUserDetails;


public class AtmUserInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		System.out.println("***********Welcome to Employee Administration****************");
		
		
		System.out.println("1: Sign up");
		System.out.println("2: Sign In");
		System.out.println("3: Exit");
		System.out.println("*************************************************************");
		char ch=' ';
		char ch1=' ';
		AtmLoginDetailsDao LoginDao=new AtmLoginDetailsDaoImpl();
		AccountDaoImpl accountDao=new AccountDaoImpl();
		AdminDaoImpl adminDao=new AdminDaoImpl();
		boolean flag=false;
		String username,firstname,lastname,password, location, mobileno,role,fullname,location1;
		int accountno,cust_Id;
		do {
			System.out.println("What you do wish to check from the above list");
		     Scanner sn=new Scanner(System.in);
			  int option=sn.nextInt();
		   
			switch(option)
			{
				case 1: 
					System.out.println("enter the details to signup");
					System.out.println("Enter the firsname:");
					firstname=sn.next();
					System.out.println("Enter the lastname:");
					lastname=sn.next();
					System.out.println("Enter the location:");
					location=sn.next();
					System.out.println("Enter the mobileno:");
					mobileno=sn.next();
					System.out.println("Enter the username:");
					username=sn.next();
					boolean valid=AtmLoginDetailsDaoImpl.isValidUsername(username);
				   while(valid==false)
				     {
				    	System.out.println("Username is not valid please enter the valid Username!!");
				    	  username=sn.next();
				    	  valid=AtmLoginDetailsDaoImpl.isValidUsername(username);
				   }
			
				   System.out.println("Enter the password:");
					password=sn.next();
					boolean validpwd=AtmLoginDetailsDaoImpl.isValidPwd(password);
					while(validpwd==false)
				     {
				    	System.out.println("Password is not valid please Enter the valid Password!!");
				    	  password=sn.next();
				    	  validpwd=AtmLoginDetailsDaoImpl.isValidPwd(password);
				   }
					System.out.println("Enter the role:");
					role=sn.next();
					AtmUserDetails user=new AtmUserDetails();
					user.setFirstName(firstname);
					user.setLastName(lastname);
					user.setLocation(location);
					user.setMobileno(mobileno);
					user.setUsername(username);
					user.setPassword(password);
					user.setRole(role);
				    LoginDao.signUp(user);
				    System.out.println("You have successfully sign up");
				    System.out.println("If you want to do transaction please signIn!!");
				    	
                  break;
				case 2: 
					System.out.println("Enter the username");
					String usern=sn.next();
				    System.out.println("Enter the password");
					String pass=sn.next();
					System.out.println("Enter the role");
					String trole=sn.next();
					AtmUserDetails details=new AtmUserDetails();
					
					details.setUsername(usern);
					details.setPassword(pass);
					details.setRole(trole);
					boolean res=LoginDao.signIn(details);
					if(res)
					{	
						System.out.println("login success");
						if(trole.equals("customer") && flag==false)
						{
                  	 	System.out.println("Check Menu");
					    System.out.println("1.Deposit Amount");
					    System.out.println("2.Withdraw Amount");
					    System.out.println("3.Checking balance");
					    System.out.println("4.Exit");
					    int choice;
				    	do
				    	{
				    		System.out.println("Select any option from the menu");
						     Scanner sc=new Scanner(System.in);
							  choice=sc.nextInt();
							  switch(choice)
							  {
							  case 1:
								  System.out.println("Enter the account no");
								  int accno=sn.nextInt();
								  System.out.println("Enter the amount to be deposited:");
								  int amount=sn.nextInt();
								boolean rs1=accountDao.deposit(accno,amount);
							      if(rs1)
								{
							System.out.println("Deposit Successfully");
								}
								else
								{
									System.out.println("Invalid Account Number");
								}
							  break;
							  case 2:
								  System.out.println("Enter the account no");
								  int accno2=sn.nextInt();
								  System.out.println("Enter the amount to be withdraw");
								  int amt1=sn.nextInt();
								   
								    boolean res4=accountDao.withdraw(accno2,amt1);
								    if(res4)
								    	System.out.println("Withdraw Successfully");
								    else 
								    	System.out.println("Withdraw failed");
								    break;
							  case 3:
								  System.out.println("Enter the account no");
								  int accno1=sn.nextInt();
							  System.out.println(accountDao.balance(accno1));
								   break;
							  case 4:
								  System.exit(0);
							    default: System.out.println("enter the valid option");
						        }
					         System.out.println("Do you want  to check any  other options");
					           ch1=sn.next().charAt(0);
					           
				    	}while(ch1=='y' || ch1=='Y');
						}
						else
						{
						System.out.println("Check the operations:");
						System.out.println("1.Adding Users");
						System.out.println("2.Delete User");
						System.out.println("3.All user Details");
						System.out.println("4.exit");
						do
						{
							System.out.println("Enter the choice");
							int choice=sn.nextInt();
							switch(choice)
							{
							case 1:
								System.out.println("Enter the customer details:");
								System.out.println("Enter the customer Id:");
								cust_Id=sn.nextInt();
								System.out.println("Enter the fullname:");
								StringBuffer sb = new StringBuffer();
								String name = sn.nextLine();  
						        sb.append(sn.nextLine());  
								fullname=sb.toString();  
								System.out.println("Enter the location:");
								location1=sn.next();
								System.out.println("Enter the accountno:");
								accountno=sn.nextInt();
								
								Admin adm=new Admin();
								adm.setCust_Id(cust_Id);
								adm.setFullname(fullname);
								adm.setLocation(location1);
								adm.setAccountno(accountno);
							    adminDao.addUsers(adm);
							    break;
							case 2:
								System.out.println("Enter the customer Id");
								      int id=sn.nextInt();
								boolean check=adminDao.deleteUser(id);
								if(check==true){
									System.out.println("deleted successfully");
								}
						
								break;
							case 3:
								    System.out.println("User Details");
								    ArrayList<Admin> arrayList = adminDao.allUsers();
								    Iterator<Admin> iterator = arrayList.iterator();
								    while(iterator.hasNext())
								    {
								    	Admin admin =new Admin();
								    	admin=iterator.next();
								    	System.out.println("User Id-->"+" " +admin.getCust_Id());
								    	System.out.println("User Fullname-->"+" "+admin.getFullname());
								    	System.out.println("User Location-->"+" "+admin.getLocation());
								    	System.out.println("User AcountNo-->"+" "+admin.getAccountno());
								    }
								    
								    break;
								    
							case 4:
								System.exit(0);
						    default: System.out.println("enter the valid option");
				}
				         System.out.println("Do you wish to check other operations");
				           ch=sn.next().charAt(0);
				 }while(ch=='y'||ch=='Y');
						
						}	
					}			
		
				     else
				     {
						System.out.println("login failed");
				     }
					break;
				case 3:
					System.exit(0);
				    default: System.out.println("enter the valid option");
		}
		         System.out.println("Do you wish to check other options");
		           ch=sn.next().charAt(0);
		 }while(ch=='y'||ch=='Y');
					
				
	}
	

}

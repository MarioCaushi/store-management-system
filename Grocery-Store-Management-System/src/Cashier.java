import java.io.*;

public class Cashier extends Person implements Serializable{
 
	private static final long serialVersionUID = 1L;
	
	//Constructor with given password for Cashier
	public Cashier(String name,String surname,int day,int month,int year,String password,String username) throws IllegalArgumentException
	{ 
		super(name,surname,day,month,year,password,username);
	}
	
	//Constructor with random password for Cashier
	public Cashier(String name,String surname,int day,int month,int year,String username) throws IllegalArgumentException
	{
		super(name,surname,day,month,year,username);
	}
	
	  //Getters of data fields
	  //using appropriate naming to differentiate methods
	
	
	//Setters of data fields
	//using appropriate naming to differentiate methods
	
	
	@Override
	//A toString method with a boolean argument to choose if the password will be shown or not
	public String toString(boolean x)
	{
		if(x)
		{
		return "Cashier: \n Name: "+this.getName()+" Surname: "+this.getSurname()+" Username: "+this.getUsername()+ " Birthday: "+this.getBirthday()+" Date registered: "+this.getDateRegistered()+" Password: "+this.getPassword();
		}
		else
		{
		return "Cashier: \n Name: "+this.getName()+" Surname: "+this.getSurname()+" Username: "+this.getUsername()+ " Birthday: "+this.getBirthday()+" Date registered: "+this.getDateRegistered();
		}
	}
}

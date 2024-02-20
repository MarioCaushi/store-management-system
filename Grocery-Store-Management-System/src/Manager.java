import java.io.*;

public class Manager extends Person implements Serializable {
	 
	private static final long serialVersionUID = 1L;
    
	//Constructor with given password for Manager
	public Manager(String name,String surname,int day,int month,int year,String password,String username) throws IllegalArgumentException
	{
		super(name,surname,day,month,year,password,username);
	}
	 
	//Constructor with random password for Manager
	public Manager(String name,String surname,int day,int month,int year,String username) throws IllegalArgumentException
	{
		super(name,surname,day,month,year,username);
	}
	
	@Override
	//A toString method with a boolean argument to choose if the password will be shown or not
	public String toString(boolean x)
	{
		if(x)
		{
		return "Manager: \n Name: "+this.getName()+" Surname: "+this.getSurname()+" Username: "+this.getUsername()+ " Birthday: "+this.getBirthday()+" Date registered: "+this.getDateRegistered()+" Password: "+this.getPassword();
		}
		else
		{
		return "Manager: \n Name: "+this.getName()+" Surname: "+this.getSurname()+" Username: "+this.getUsername()+ " Birthday: "+this.getBirthday()+" Date registered: "+this.getDateRegistered();
		}
	}
}

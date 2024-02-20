import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public abstract class Person implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private String surname;
	private int day;  //day of birth
	private int month;  //month of birth
	private int year;  //year of birth
	private String date; //Date registered
	private String password;
	private String username;
	
	 
	//Constructor for when the password is given by the user
	protected Person(String name, String surname, int day, int month, int year, String password,String username) throws IllegalArgumentException
	{
		this.name=name;
		this.surname=surname;
		this.day=day;
		this.month=month;
		this.year=year;
		this.password=password;
		this.username=username;
		this.date=getLocalDateTimeAsString();
	}
	
	//Constructor for when the password is auto-generated
	protected Person(String name,String surname,int day,int month,int year,String username) throws IllegalArgumentException
	{
		this.name=name;
		this.surname=surname;
		this.day=day;
		this.month=month;
		this.year=year;
		this.username=username;
		this.password=generatePassword((int)(Math.random()*10)+5); //generates a random length from 5 to 14 inclusive
		this.date=getLocalDateTimeAsString();
	}
	
	protected Person(String name,String surname)
	{
		this.name=name;
		this.surname=surname;
		this.date=getLocalDateTimeAsString();
	}
	
	//A function to generate a random password
	public static String generatePassword(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characters.length());
            password.append(characters.charAt(randomIndex));
        }

        return password.toString();
    }
	
	//A function to receive the local date and time a person is registered(String)
	  public static String getLocalDateTimeAsString() {
	        LocalDateTime currentDateTime = LocalDateTime.now();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        return currentDateTime.format(formatter);
	    }
	  
	  //Getters of data fields
	  //using appropriate naming to differentiate methods
	  
	  public String getName()
	  {
		  return this.name;
	  }
	  public String getSurname()
	  {
		  return this.surname;
	  }
	  public int getDay()
	  {
		  return this.day;
	  }
	  public int getMonth()
	  {
		  return this.month;
	  }
	  public int getYear()
	  {
		  return this.year;
	  }
	  public String getDateRegistered()
	  {
		  return this.date;
	  }
	  public String getPassword()
	  {
		  return this.password;
	  }
	  //method to get the full birthday in a string format
	  public String getBirthday()
	  {
		  return this.day+"."+this.month+"."+this.year;
	  }
	  public String getUsername()
	  {
		  return this.username;
	  }
	  
	  //Setters of data fields
	  //using appropriate naming to differentiate methods
	  
	  public void setName(String name)
	  {
		  this.name=name;
	  }
	  public void setSurname(String surname)
	  {
		  this.surname=surname;
	  }
	  
		  public void setDay(int day) throws IllegalArgumentException {
			    int maxDays;
			    
			    // Assigning maximum days based on the month
			    switch (this.month) {
			        case 1, 3, 5, 7, 8, 10, 12:
			            maxDays = 31;
			            break;
			        case 4, 6, 9, 11:
			            maxDays = 30;
			            break;
			        case 2:
			            maxDays = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) ? 29 : 28; // Leap year check for February
			            break;
			        default:
			            throw new IllegalArgumentException("Invalid month: " + month);
			    }

			    // Checking if the provided day falls within the valid range for the given month
			    if (day < 1 || day > maxDays) {
			        throw new IllegalArgumentException("Invalid day for month " + month + ": Day should be between 1 and " + maxDays);
			    }
			    
			    this.day = day;
			}

	  public void setMonth(int month) throws InputMismatchException, IllegalArgumentException {
		    if (month < 1 || month > 12) {
		        throw new IllegalArgumentException("Invalid month. Month should be between 1 and 12.");
		    }
		    this.month = month;
		}
	  
	  //A method to set a year based on the preferred year but checking if the year set corresponds to the person being more than 18 years old
	  public void setYear(int year) throws IllegalArgumentException
	  {
		// Get the current date
	        LocalDate currentDate = LocalDate.now();

	        // Extract year, month, and day from the current date
	        int currentYear = currentDate.getYear();
	        int currentMonth = currentDate.getMonthValue();
	        int currentDay = currentDate.getDayOfMonth();
	        
	        if(currentYear-year<18)
	        {
	        	throw new IllegalArgumentException("You need to be 18+. Error!");
	        }
	        else if(currentYear-year==18)
	        {
	        	if(this.month==currentMonth)
	        	{
	        		if(this.day>currentDay)
	        		{
	        			throw new IllegalArgumentException("You need to be 18+. Error!");
	        		}
	        		if(this.day==currentDay || this.day<currentDay)
	        		{
	        			System.out.println("Desired Year set successfully");
	        			this.year=year;
	        		}
	        	}
	        }
	        else
	        {
	        	System.out.println("Desired Year set successfully");
	        	this.year=year;
	        }
	  }
	  
	  public void setPassword(String password) 
	  {
	      this.password=password;
	  }
	  
	  //A setter to check if the given username corresponds to somebody else's
	  public void setUsername(String username) throws IllegalArgumentException
	  {
		  //Check if the username entered corresponds the same with the username of somebody else
		  if(this instanceof Manager)
		  { 
			  for(int i=0;i<GroceryStore.managerList.size();i++)
			  {
				  if(username.equals(GroceryStore.managerList.get(i).getUsername()))
				  {
					  throw new IllegalArgumentException("You have entered the same username as somebody else. Try Again!"); 
				  }
			  } 
			  if(this.getUsername().equals(username))
			  {
				  throw new IllegalArgumentException("You have entered the same username. Try Again!"); 
			  }
			  else
			  {
				  this.username=username;
			  }
		  }
		  else
		  {		  
			  for(int i=0;i<GroceryStore.cashierList.size();i++)
			  {
				  if(username.equals(GroceryStore.cashierList.get(i).getUsername()))
				  {
					  throw new IllegalArgumentException("You have entered the same username as somebody else. Try Again!"); 
				  }
			  } 
			  if(this.getUsername().equals(username))
			  {
				  throw new IllegalArgumentException("You have entered the same username. Try Again!"); 
			  }
			  else
			  {
				  this.username=username;
			  }
		  }
	  }
	  
	  //Abstract method toString
	  public abstract String toString(boolean x);
}

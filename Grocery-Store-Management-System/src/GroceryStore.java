import java.util.*;

import javafx.application.Platform;
import javafx.scene.control.TextField;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;

public class GroceryStore implements Serializable{
 
	public static ArrayList<Person> personList;
	public static ArrayList<Manager> managerList;
	public static ArrayList<Cashier> cashierList;
	public static ArrayList<Costumer> costumerList;
	public static ArrayList<Product> productList;
	public static ArrayList<ProductSold> salesList;
	public static ArrayList<ProductSold> dailySalesList;
	public static ArrayList<ProductSold> weeklySalesList;
	public static ArrayList<ProductSold> monthlySalesList;
	public static ArrayList<ProductSold> yearlySalesList;

	public static double loyaltyRatio;
	public static int loyaltyPoints;
	public static double discount;
	public static int noOfItems;
	public static int loyaltyPoints1;

//	public static ArrayList<Product> productList;
	
	public GroceryStore()
	{
		this.personList=new ArrayList<>();
		this.managerList=new ArrayList<>();
		this.cashierList=new ArrayList<>();
		this.costumerList=new ArrayList<>();
		this.productList=new ArrayList<>();
		this.salesList=new ArrayList<>();
		this.dailySalesList=new ArrayList<>();	
		this.weeklySalesList=new ArrayList<>();
		this.monthlySalesList=new ArrayList<>();
		this.yearlySalesList=new ArrayList<>();
		
		this.loyaltyRatio=0;
		this.discount=0;
		this.loyaltyPoints=0;
		this.noOfItems=0;
		this.loyaltyPoints1=0;
	}
	

	public static int getLoyaltyPoints1() {
		return loyaltyPoints1;
	}

	public static void setLoyaltyPoints1(int loyaltyPoints1) {
		GroceryStore.loyaltyPoints1 = loyaltyPoints1;
	}


	public static int getNoOfItems() {
		return noOfItems;
	}

	public static void setNoOfItems(int noOfItems) {
		GroceryStore.noOfItems = noOfItems;
	}


	public static int getLoyaltyPoints() {
		return loyaltyPoints;
	}

	public static void setLoyaltyPoints(int loyaltyPoints) {
		GroceryStore.loyaltyPoints = loyaltyPoints;
	}


	public static double getDiscount() {
		return discount;
	}
	public static void setDiscount(double discount) {
		GroceryStore.discount = discount;
	}

	public static double getLoyaltyRatio() {
		return loyaltyRatio;
	}


	public static void setLoyaltyRatio(double x, double y) {
		
		
		GroceryStore.loyaltyRatio=x/y;
	}



	public static int convertMonthFromStringToInt(String month) throws IllegalArgumentException
	{
	    int x = 0; // Initialize x to handle cases where the month doesn't match any case

	    switch(month) {
	        case "January":
	            x = 1;
	            break;
	        case "February":
	            x = 2;
	            break;
	        case "March":
	            x = 3;
	            break;
	        case "April" :
	            x = 4;
	            break;
	        case "May" :
	            x = 5;
	            break;
	        case "June" :
	            x = 6;
	            break;
	        case "July" :
	            x = 7;
	            break;
	        case "August" :
	            x = 8;
	            break;
	        case "September" :
	            x = 9;
	            break;
	        case "October" :
	            x = 10;
	            break;
	        case "November" :
	            x = 11;
	            break;
	        case "December" :
	            x = 12;
	            break;
	        default:
	           throw new IllegalArgumentException("Invalid Month");
	    }
	    
	    return x; // Return x, even for invalid month names (which will return 0)
	}

	public static void openPersonDatabase() throws IOException, ClassNotFoundException {
	    String personFilePath = "database/person.dat"; // Specify the file relative path
	    String productFilePath="database/product.dat";

	    File file = new File(personFilePath);
	    File file1=new File(productFilePath);

	    if (file.exists()) {
	        try (FileInputStream personFile = new FileInputStream(personFilePath);
	             ObjectInputStream personInputStream = new ObjectInputStream(personFile)) 
	        {
	            ArrayList<Person> readObject = (ArrayList<Person>) personInputStream.readObject();
	            GroceryStore.personList = readObject;
	        }
	    } else {
	        System.out.println("File is empty or does not exist.");
	    }
	    if (file1.exists() && file1.length() >0) {
	    	try (FileInputStream productFile = new FileInputStream(productFilePath);
	    		     ObjectInputStream productInputStream = new ObjectInputStream(productFile)) 
	    	{
	    		    ArrayList<Product> productList = (ArrayList<Product>) productInputStream.readObject();
	    		    GroceryStore.productList = productList;
	    }
	    }
	    else if(file1.exists() && file1.length()==0)
        {
        	System.out.println("Product file exists but is empty");
        }else {
	    	
	        System.out.println("File is empty or does not exist.");
	    }
	    
	    if(file.exists() &&file1.exists())
	    { Platform.runLater(() -> {

	        Login.displayInfo("Program Information", "Database loaded successfully");
	    });
	} 
	    else
	    {
	    	Platform.runLater(() -> {
		        
		        Login.displayInfo("Program Information", "Database did not load ");
		    });
	    }
	}
	
	
	public static void openPersonDatabaseWithoutMessage() throws IOException, ClassNotFoundException {
		 String personFilePath = "database/person.dat"; // Specify the file relative path
		    String productFilePath="database/product.dat";

		    File file = new File(personFilePath);
		    File file1=new File(productFilePath);

		    if (file.exists()) {
		        try (FileInputStream personFile = new FileInputStream(personFilePath);
		             ObjectInputStream personInputStream = new ObjectInputStream(personFile)) 
		        {
		            ArrayList<Person> readObject = (ArrayList<Person>) personInputStream.readObject();
		            GroceryStore.personList = readObject;
		        }
		    } else {
		        System.out.println("File is empty or does not exist.");
		    }
		    if (file1.exists() && file1.length() >0) {
		    	try (FileInputStream productFile = new FileInputStream(productFilePath);
		    		     ObjectInputStream productInputStream = new ObjectInputStream(productFile)) 
		    	{
		    		    ArrayList<Product> productList = (ArrayList<Product>) productInputStream.readObject();
		    		    GroceryStore.productList = productList;
		    }
		    }
		    else if(file1.exists() && file1.length()==0)
	        {
	        	System.out.println("Product file exists but is empty");
	        }else {
		    	
		        System.out.println("File is empty or does not exist.");
		    }
	
	    }
	
	public static void storeInPersonDatabase() {
	    String personFilePath = "database/person.dat";
	    String productFilePath = "database/product.dat";

	    try (FileOutputStream personFileStream = new FileOutputStream(personFilePath);
	         BufferedOutputStream personBufferedStream = new BufferedOutputStream(personFileStream);
	         ObjectOutputStream personOutputStream = new ObjectOutputStream(personBufferedStream);
	         FileOutputStream productFileStream = new FileOutputStream(productFilePath);
	         BufferedOutputStream productBufferedStream = new BufferedOutputStream(productFileStream);
	         ObjectOutputStream productOutputStream = new ObjectOutputStream(productBufferedStream)) {

	        personOutputStream.writeObject(GroceryStore.personList);
	        productOutputStream.writeObject(GroceryStore.productList);

        Platform.runLater(() -> {
		        
	    Login.displaySuccessAlert("Program Information", "Successfully Stored");
		    });
	        

	    } catch (IOException e) {
	    	Platform.runLater(() -> {
		        
	    		 Login.displayErrorAlert("Program Information", "Data not stored\nError!");
	    		    });
	        Login.displayErrorAlert("Program Information", "Data not stored\nError!");
	    }
	}


	public static Person getCertainPerson(TextField usernametxfl)
	{
		Person person=null;
		for(int i=0;i<GroceryStore.personList.size();i++)
		{
			if(usernametxfl.getText().equals(GroceryStore.personList.get(i).getUsername()))
			{
				person=GroceryStore.personList.get(i);
				break;
			}
		}
		
		return person;
	}
	
	public static int getCertainPersonIndex(Person person) {
	    for (int i = 0; i < GroceryStore.personList.size(); i++) {
	        if (person.getUsername().equals(GroceryStore.personList.get(i).getUsername())) {
	            return i;
	        }
	    }
	    return -1; // Username not found
	}
	
	//A method that arranges the database
	//it takes the personList and seperates it into the costumer,manager and cashier seperate lists
	public static void arrangeDatabase()
	{
	    GroceryStore.managerList.clear();
	    GroceryStore.cashierList.clear();
	    GroceryStore.costumerList.clear();
	    
		for(int i=0;i<GroceryStore.personList.size();i++)
		{
			if(GroceryStore.personList.get(i) instanceof Manager)
			{
				GroceryStore.managerList.add((Manager)GroceryStore.personList.get(i));
			}
			else if(GroceryStore.personList.get(i) instanceof Cashier)
			{
				GroceryStore.cashierList.add((Cashier)GroceryStore.personList.get(i));
			}
			else
			{
				GroceryStore.costumerList.add((Costumer)GroceryStore.personList.get(i));
			}
				
		}
	}
	
	public static Person findCorrespondingPersoninPersonList(Person person)
	{
		Person x=null;
		
		for(int i=0;i<GroceryStore.personList.size();i++)
		{
			if(person.getDateRegistered().equals(GroceryStore.personList.get(i).getDateRegistered()))
			{
				x=GroceryStore.personList.get(i);
					return x;
			}
		}
		return x;
	}
	
	
	public static Manager findCorrespondingManagerinManagerList(Person person)
	{
		Manager x=null;
		
		for(int i=0;i<GroceryStore.personList.size();i++)
		{
			if(person.getDateRegistered().equals(GroceryStore.managerList.get(i).getDateRegistered()))
			{
				x=GroceryStore.managerList.get(i);
					return x;
			}
		}
		return x;
	}
	
	
	public static boolean isSupplierEmpty(Product product)
	{
		if(product.getSupplier() == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	public static double calculateCostWithoutDiscount()
	{
		double sum=0;
		
		for(int i=0;i<GroceryStore.salesList.size();i++)
		{
			sum=(GroceryStore.salesList.get(i).getPrice()*GroceryStore.salesList.get(i).getQuantity())+sum;
		}
		
		return sum;
	}
	
	
	public static double calculateCostWithDiscount(Costumer costumer)
	{
		double sum=calculateCostWithoutDiscount();
		
		return sum=sum-((sum*costumer.getDiscount())/100);
	}
	
	
	public static void arrangeProductDatabase()
	{
		GroceryStore.dailySalesList.clear();
		GroceryStore.monthlySalesList.clear();
		GroceryStore.yearlySalesList.clear();
		GroceryStore.weeklySalesList.clear();
		
		for(int i=0;i<GroceryStore.productList.size();i++)
		{
			if(GroceryStore.productList.get(i) instanceof ProductSold)
			{
				LocalDate currentDate = LocalDate.now();

		        int currentYear = currentDate.getYear();
		        int currentMonth = currentDate.getMonthValue();
		        int currentDay = currentDate.getDayOfMonth();
		        
		        int year=GroceryStore.productList.get(i).getYearSold();
		        int month=GroceryStore.productList.get(i).getMonthSold();
		        int day=GroceryStore.productList.get(i).getDaySold();
		        
		        int currentSum=currentYear*365+currentMonth*30+currentDay;
		        int sum=year*365+month*30+day;
		        
		        int difference=currentSum-sum;
		        
		        if(difference<=1)
		        {
		        	GroceryStore.dailySalesList.add((ProductSold) GroceryStore.productList.get(i));
		        }
		        if(difference<8)
		        {
		        	GroceryStore.weeklySalesList.add((ProductSold) GroceryStore.productList.get(i));
		        }
		         if(difference<31)
		        {
		        	GroceryStore.monthlySalesList.add((ProductSold) GroceryStore.productList.get(i));
		        }
		        if(difference<366)
		        {
		        	GroceryStore.yearlySalesList.add((ProductSold) GroceryStore.productList.get(i));
		        }
			}
		}
	}
}

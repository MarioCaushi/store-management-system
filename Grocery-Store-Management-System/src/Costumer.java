import java.io.*;
import java.util.ArrayList;

public class Costumer extends Person implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private String email;
    private int loyaltyPoints;
    private double discount;
	private ArrayList<ProductSold> boughtList;
    
    public Costumer (String name,String surname )
    {
    	super(name,surname);
    	this.loyaltyPoints=0;
    	this.discount=0;
    	this.email=null;
    	this.boughtList=new ArrayList<>();
    }
    
    public Costumer (String name,String surname,String email)
    {
    	super(name,surname);
    	this.loyaltyPoints=0;
    	this.discount=0;
    	this.email=email;
    	this.boughtList=new ArrayList<>();
    }
    
    //Getters for the data fields
    public String getEmail()
    {
    	return this.email;
    }
    public int getLoyaltyPoints()
    {
    	return this.loyaltyPoints;
    }
    public double getDiscount()
    {
    	return this.discount;
    }
    
    //Setters for the data fields
    public void setEmail(String email)
    {
    	this.email=email;
    }
    public void setLoyaltyPoints(int x)
    {
    	this.loyaltyPoints=x;
    }
    public void setDiscount(double x)
    {
    	this.discount=x;
    }
    

	public int getSize()
	{
		int x;
		if(this.boughtList==null)
		{
			x=0;
		}
		else
		{
			x=this.boughtList.size();
		}
		
		return x;
	}
	public void addBoughtItems(ProductSold product)
	{
		this.boughtList.add(product);
	}
	public ProductSold getBoughtItems(int x)
	{
		return this.boughtList.get(x);
	}
	
	public ArrayList<ProductSold> getAllItems()
	{
		return this.boughtList;
	}
	public int sizeItemsBought()
	{
		int sum=0;
		for(int i=0;i<this.boughtList.size();i++)
		{
			sum=sum+(this.boughtList.get(i).getQuantity());
		}
		
		return sum;
	}
	

	@Override
	public String toString(boolean x)
	{
		if(x)
		{
		return "Costumer: Name: "+this.getName()+"    Surname: "+this.getSurname();
		}
		else
		{
		return "Cashier: Name: "+this.getName()+" Surname: "+this.getSurname()+" Username: "+this.getUsername()+ "\n Birthday: "+this.getBirthday()+" Date registered: "+this.getDateRegistered();
		}
	}

	
	

}

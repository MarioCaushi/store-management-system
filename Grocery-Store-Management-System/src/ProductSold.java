import java.io.Serializable;

public class ProductSold extends Product implements Serializable{

	private String name;
	private String category;
	private double price;
	private int quantity;
	private String supplier;
	private String dateAdded;
	private int daySold;
	private int monthSold;
	private int yearSold;
	private int serialNumber;
	
	
	
	public ProductSold (String name,String category, double price,int quantity,String supplier)
	{
		
		super(name,category,price,quantity,supplier);
		this.daySold=0;
		this.monthSold=0;
		this.yearSold=0;
		this.serialNumber=0;
		this.dateAdded=Person.getLocalDateTimeAsString();
	}
	
	public ProductSold(String name,String category,double price,int quantity)
	{
		
		super(name,category,price,quantity);
		this.supplier=null;
		this.daySold=0;
		this.monthSold=0;
		this.yearSold=0;
		this.serialNumber=0;
		this.dateAdded=Person.getLocalDateTimeAsString();
	}
}
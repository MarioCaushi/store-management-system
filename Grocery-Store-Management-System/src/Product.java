import java.io.Serializable;

public class Product implements Serializable{

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
	
	
	
	public Product (String name,String category, double price,int quantity,String supplier)
	{
		this.name=name;
		this.category=category;
		this.price=price;
		this.quantity=quantity;
		this.supplier=supplier;
		this.daySold=0;
		this.monthSold=0;
		this.yearSold=0;
		this.serialNumber=0;
		this.dateAdded=Person.getLocalDateTimeAsString();
	}
	
	public Product(String name,String category,double price,int quantity)
	{
		this.name=name;
		this.category=category;
		this.price=price;
		this.quantity=quantity;
		this.supplier=null;
		this.daySold=0;
		this.monthSold=0;
		this.yearSold=0;
		this.serialNumber=0;
		this.dateAdded=Person.getLocalDateTimeAsString();
	}

	
	
	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getSupplier() {
		return supplier;
	}
	

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public String getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public int getDaySold() {
		return daySold;
	}

	public void setDaySold(int daySold) {
		this.daySold = daySold;
	}

	public int getMonthSold() {
		return monthSold;
	}

	public void setMonthSold(int monthSold) {
		this.monthSold = monthSold;
	}

	public int getYearSold() {
		return yearSold;
	}

	public void setYearSold(int yearSold) {
		this.yearSold = yearSold;
	}
	
	public void setDateSold(int day,int month, int year)
	{
		this.daySold=day;
		this.monthSold=month;
		this.yearSold=year;
	}
	
	public String getDateSold()
	{
		return this.getDaySold()+"."+this.getMonthSold()+"."+this.getYearSold();
	}
	
	@Override
	public String toString() {
		return "Product [name=" + name + ", category=" + category + ", price=" + price + ", quantity=" + quantity
				+ ", supplier=" + supplier + ", dateAdded=" + dateAdded + ", daySold=" + daySold + ", monthSold="
				+ monthSold + ", yearSold=" + yearSold + "]";
	}
	
}

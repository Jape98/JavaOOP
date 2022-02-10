package hw4;

public class VendorParts extends Parts {

	public String vendorName;
	public double vendorPrice;
	
	public VendorParts(String name, int stock, String vendorName, double vendorPrice) {
		super(name, stock);
	
		this.vendorName = vendorName;
		this.vendorPrice = vendorPrice;
	}
	
	/*Getters-----------------------------------------*/
	public String getVendorName() {
		return vendorName;
	}
	public double getVendorPrie() {
		return vendorPrice;
	}
	
	/*Other-methods-----------------------------------*/
	public double stockWorth() {
		return(stock * vendorPrice);
	}
	public String toString() {
		
		return ("Name: "+this.getName() +", Stock: "+ this.getStock() +", Vendor Name: "+ this.getVendorName() +", Vendor Price: "+ this.getVendorPrie());
	}
}

package hw4;

public abstract class Parts {

	private String name;
	public int stock;
	
	/*Constructor-------------------------------------*/
	public Parts(String name, int stock) {
		
		this.name = name;
		this.stock = stock;
	}
	
	/*Getters-----------------------------------------*/
	public String getName() {
		return name;
	}
	
	public int getStock() {
		return stock;
	}
	
	public double stockWorth() {
		return (0);
	   }
	
	public String toString() {
		return("");
	}
}

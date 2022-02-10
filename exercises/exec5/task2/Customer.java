package exec5.task2;

public class Customer {

	private String name, address;
	private int cNumber;
	
	
	
	/*----------CONSTRUCTOR----------*/
	public Customer(int cNumber, String name, String address) {
		
		this.cNumber = cNumber;
		this.name = name;
		this.address = address;
		
	}
	
	/*-------------GET & SET-----------*/
	public int getcNumber() {
		return cNumber;
	}
	public void setcNumber(int cNumber) {
		this.cNumber = cNumber;
	}
	public String getAdrress() {
		return address;
	}
	public void setAdrress(String adrress) {
		this.address = adrress;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	/*---------OTHERS-----------------*/
	public String toString(){
    	
        return"Customer number " + this.cNumber + ":, Name: " + this.name + ", Address: " + this.address;
    }
	
	
}

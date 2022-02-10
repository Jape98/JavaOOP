package hw4;

public class OwnParts extends Parts {

	public double materialCost, materialNeed;

	/*Constructor-------------------------------------*/
	public OwnParts(String name, int stock, double materialCost, double materialNeed) {
		super(name,stock);
		
		this.materialCost = materialCost;
		this.materialNeed = materialNeed;
	}
	
	/*Getters-----------------------------------------*/
	public double getMaterialCost() {
		return materialCost;
	}
	public double getMaterialNeed() {
		return materialNeed;
	}
	
	/*Other-methods-----------------------------------*/
	public double stockWorth() {
		return(stock * materialNeed * materialCost);
	}
	
	public String toString() {
		
		return ("Name: " + this.getName() +", Stock: "+ this.getStock() +", Material cost: "+ this.getMaterialCost() +", Material needed: "+ this.getMaterialNeed());
	}
}

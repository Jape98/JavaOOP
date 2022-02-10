package exec5.task2;

public class PreferredCustomer extends Customer {

	private int purchases;
	

/*----------CONSTRUCTOR----------*/
public PreferredCustomer(int cNumber, String name, String address, int purchases) {
		
		super(cNumber, name, address);
		this.setPurchases(purchases);
		
	}

/*-------------GET & SET-----------*/
	public int getPurchases() {
		return purchases;
	}
	
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
	
	public String toString() {
        
        return super.toString() + ", Purchases: " + purchases + "ä, Bonus: " + calculateBonus() +"%";

    }
	
	public double calculateBonus() {
		
		if (1000>purchases && 500<purchases) {
			return 2;
		}
		else if (1000<purchases) {
			return 5;
		}
		else {
			return 0;
		}
		
	}

}

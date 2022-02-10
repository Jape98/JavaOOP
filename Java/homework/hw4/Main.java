package hw4;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Parts> parts = new ArrayList<Parts>();
		
		parts.add(new OwnParts("Piston", 432, 11.5, 3));
		parts.add(new OwnParts("Connecting rod", 191, 6.55, 2));
		parts.add(new OwnParts("Rod cap", 232, 3.50, 1));
		
		parts.add(new VendorParts("Bearing", 300, "Laakeri-Center Oy Ab", 5.99));
		parts.add(new VendorParts("Gasket", 100, "Lakeuden Hydro Oy", 1.99));
		
		for(int i=0; i<parts.size(); i++) {
	        System.out.print("Part: " + parts.get(i).getName() + ", Worth: " + parts.get(i).stockWorth()+ "\n");
	    }
		
			System.out.print("\n");
		
		for(int i=0; i<parts.size(); i++) {
			
			System.out.print(parts.get(i).toString() +"\n");
	    }
	}
}

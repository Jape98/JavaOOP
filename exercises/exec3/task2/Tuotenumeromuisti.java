package exec3.task2;

import java.util.HashMap;
import java.util.Scanner;

public class Tuotenumeromuisti {

	public static void main(String[] args) {

		HashMap<Integer, Double> storage = new HashMap<>();
		
		storage.put(1, 5.50);
		storage.put(2, 10.50);
		storage.put(3, 15.23);
		storage.put(4, 20.43);
		storage.put(5, 25.99);
		storage.put(6, 30.45);
		storage.put(7, 35.99);
		storage.put(8, 40.15);
		storage.put(9, 50.0);
		storage.put(10, 100.0);
		
		System.out.println("Tuotenumero: (0 Lopettaa)");
		Scanner input = new Scanner(System.in);
		
		int tuoteNro = input.nextInt();
		
		while(tuoteNro > 0) {
			
			if(storage.containsKey(tuoteNro) == true) {
				System.out.println("Tuotteen hinta: " + storage.get(tuoteNro) + "ä\n");
				System.out.println("Syätä tuotenumero: ");
				tuoteNro = input.nextInt();
				
			} else if(storage.containsKey(tuoteNro) == false) {
				System.out.println("Virheelinen tuotenumero\n");
				System.out.println("Syätä tuotenumero: ");
				tuoteNro = input.nextInt();
			}
		}
		System.out.println("End.");
		input.close();
	}

}
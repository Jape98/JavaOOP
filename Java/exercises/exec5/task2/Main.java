package exec5.task2;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		
		customers.add(new Customer(1, "Pekka", "Kotikuja 1"));
		customers.add(new Customer(2, "Matti", "Varastorie 22"));
		customers.add(new PreferredCustomer(3, "Maiju", "Teollisuustie 55", 50));
		customers.add(new PreferredCustomer(4, "Jaakko", "Pankkikatu 132", 1100));
		customers.add(new PreferredCustomer(5, "Salla", "Arvoitustie 64", 600));
		
		System.out.print("Kaikki asiakkaat: \n");
		
		customers.stream().filter(customer -> customer instanceof Customer).forEach(value -> System.out.print(value + "\n"));
		
		System.out.print("\nEtuasiakkaat: \n");
				
		customers.stream().filter(customer -> customer instanceof PreferredCustomer).forEach(value -> System.out.print(value + "\n"));
	}
	
	

}

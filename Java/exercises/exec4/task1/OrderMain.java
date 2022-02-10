package exec4.task1;

public class OrderMain {

	public static void main(String[] args) {
		
		Order o1 = new Order(1, "Charlie Brown", "21.10.2020");
		Order o2 = new Order(2, "Bilbo Baggins", "29.10.2020");
		
		o1.newOrderLine("Pencil", 1.5, 10);
		o1.newOrderLine("Earser", 2, 2);
		o1.newOrderLine("Binder", 10, 2);
		o1.newOrderLine("Stapler", 19.50, 1);
		
		o2.newOrderLine("A4 100pc.", 10, 100);
		o2.newOrderLine("Ink cartridge", 30, 4);

		
		System.out.println(o1.toString());
		System.out.println(o2.toString());
	}
}



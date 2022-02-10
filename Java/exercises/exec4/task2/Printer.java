package exec4.task2;

public class Printer {



	@SuppressWarnings("unused")
	private double average;
	
	public Printer(Distribution x) {
		
		this.average =x.average();
}
	
	
	public void print(Distribution x) {
		for (int i = x.getMin(); i <= x.getMax(); i++) {
		
			if(x.frequency(i) == 0) {
				
				continue;

			} else {
				
				System.out.println("Luku " + i + " esiintyi: " + x.frequency(i) +" kertaa.");
			}
		}
		System.out.println("Keskiarvo: " + x.average());
	}
}

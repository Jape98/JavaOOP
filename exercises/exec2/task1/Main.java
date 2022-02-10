package exec2.task1;

public class Main {

		public static void main(String[] args) {
			
			Suorakulmio sk1= new Suorakulmio();
			Suorakulmio sk2= new Suorakulmio(5,5);
			Suorakulmio sk3= new Suorakulmio(0,0,10,3);
			
			System.out.println("Suorakulmio 1:\nKanta " + sk1.kanta() );
			System.out.println("Korkeus " + sk1.korkeus() );
			System.out.println("Pinta-ala: " + sk1.pintaAla() );
			
			System.out.println("\nSuorakulmio 2:\nKanta " + sk2.kanta() );
			System.out.println("Korkeus " + sk2.korkeus() );
			System.out.println("Pinta-ala: " + sk2.pintaAla() );
			
			System.out.println("\nSuorakulmio 3:\nKanta " + sk3.kanta() );
			System.out.println("Korkeus " + sk3.korkeus() );
			System.out.println("Pinta-ala: " + sk3.pintaAla() );
			
		}
		
}

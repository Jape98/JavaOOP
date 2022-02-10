package exec2.task2;

import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		
		Paivamaara p1 = new Paivamaara();
		Paivamaara p2 = new Paivamaara(8,12,1998);
		Paivamaara p3 = new Paivamaara("12.08.2021");
		
		System.out.println("Päivämäärä 1: "+p1.toString());
		System.out.println("Päivämäärä 2: "+p2.toString());
		System.out.println("Päivämäärä 3: "+p3.toString());
		
		System.out.println(p2.onSama(p3));
		
		System.out.println("Päivämäärä 1: "+p1.toLongString());
		System.out.println("Päivämäärä 2: "+p2.toLongString());
		System.out.println("Päivämäärä 3: "+p3.toLongString());
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Syätä kuukausi tekstinä: "); 
		String kuukaudennimi = input.nextLine();
		System.out.println(Paivamaara.kuukaudenNumero(kuukaudennimi));
		
		input.close();
	}
}

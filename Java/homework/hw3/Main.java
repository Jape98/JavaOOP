package hw3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Opetussuunitelma os1 = new Opetussuunitelma();
		
		Scanner input = new Scanner(System.in);
		int loop=1;
			
			while(loop==1) {
				
				System.out.println("Valitse: 1. Haku koodilla; 2. Haku merkkijonolla; 3. Haku laajuudella; 0 Lopetus");
				int valinta = input.nextInt();
				input.nextLine();
			
				switch(valinta) {
				
				case 0:
					loop = 0;
					break;
					
				case 1:
					System.out.println("Syätä kurssin koodi (esim. ITTA0204)");
					String kysyttyKoodi = input.nextLine();
					os1.hakuKoodilla(kysyttyKoodi);
					break;
					
				case 2:
					System.out.println("Syätä kurssin nimi (esim. Käyttäjärjestelmät)");
					String kysyttyNimi = input.nextLine();
					os1.hakuMerkkijonolla(kysyttyNimi);
					break;
					
				case 3:
					System.out.println("Syätä kurssin laajuus (esim. 5)");
					int kysyttyLaajuus = input.nextInt();
					os1.hakuLaajuudella(kysyttyLaajuus);
					break;
					
				default:
					System.out.println("Komentoa ei ole olemassa \n");
				
				}
			}
		System.out.println("End.");
		input.close();
	}

}

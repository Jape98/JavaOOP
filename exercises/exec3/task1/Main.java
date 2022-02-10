package exec3.task1;

import exec2.task2.Paivamaara;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Paivamaara> paivamaara = new ArrayList<Paivamaara>();
		
		Scanner input = new Scanner (System.in);
		
		System.out.println("Anna päivämäärä muodossa xx.xx.xxxx (tyhjä rivi lopettaa)");
		String paivamaarat = null;
		paivamaarat = input.nextLine();
		
		while(!paivamaarat.isEmpty()) {
			paivamaara.add(new Paivamaara(paivamaarat));
			paivamaarat = input.nextLine();	
		}
		
		 System.out.println("Päivämäärät");
		 
	        for(int i = 0; i < paivamaara.size(); i++){
	            System.out.println(paivamaara.get(i).toString());
	    }
	        
	    
	    System.out.println("\nAnna haettava vuosiluku: xxxx");
	    int userYear = input.nextInt();
	    
	    for(int j=0; j<paivamaara.size(); j++) {
	    	
	    	if(paivamaara.get(j).getVuosi() == userYear) {
	    		System.out.println(paivamaara.get(j).toString());
	    	}
	    }
	    
	    System.out.println("\nAnna haettava päivämäärä: xx.xx.xxxx");
	    String userDate = input.next();
	    int apu = 0;
	    
	    Paivamaara KayttajaPaivamaara = new Paivamaara(userDate);
	    
	    for(int k=0; k<paivamaara.size(); k++) {
	    	
	    	if(paivamaara.get(k).onSama(KayttajaPaivamaara) == true) {
	    		System.out.println("\nPäivämäärän indeksi " + k + ",\npäivämäärä on: ");
	    		System.out.println(paivamaara.get(k).toString());	
	    		apu ++;
	    	} 
	    	
	    }
	    
	    if(apu == 0) {
	    	System.out.println("Päivää ei läytynyt!");
	    }
	    
	    input.close();
	}
	
}
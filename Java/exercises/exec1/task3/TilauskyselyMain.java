package exec1.task3;

import java.util.Scanner;

class TilauskyselyMain {
	
   public static void main(String[] args) {
	   
	  Scanner sc = new Scanner(System.in);
	  int lkm;

	  System.out.print("Montako tuotetta? ");
	  lkm = sc.nextInt();
	   //taulukko viittauksille
	  
	  Tilaus[] tilaukset = new Tilaus[lkm];
	  //Luodaan Opiskelija-oliot ja kysytään niiden tiedot
	  
	  for(int i=0; i < lkm; i++) {
		  
	      sc.nextLine(); //rivinvaihto syättäpuskurissa ohitetaan
	      
	      tilaukset[i] = new Tilaus(); 
	      
	      System.out.println("Tuotteen nimi");
	      tilaukset[i].setTuote(sc.nextLine());
	      
	      System.out.print("Hinta\n");
	      tilaukset[i].setHinta(sc.nextDouble());
	      
	      System.out.println("Määrä?");
	      tilaukset[i].setMaara(sc.nextDouble());
	           
	  }
	  
	  System.out.println("Kokonaishinta:");
	  for(int i=0; i < lkm; i++) {
	      System.out.format("%s: %.0fkpl %.2fä  \n", tilaukset[i].getTuote(), tilaukset[i].getMaara(), tilaukset[i].yhteensa());
	  }
	  sc.close();
   }
}

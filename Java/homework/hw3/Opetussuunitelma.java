package hw3;

import java.util.HashMap;

public class Opetussuunitelma
{
	public static HashMap<String, Olio> map = new HashMap<>();
	
    public Opetussuunitelma()
    {
        Olio o1 = new Olio("ITTA0204","Olio-ohjelmointi", 5);
        Olio o2 = new Olio("ITTP0311", "Tietoverkkojen palvelut", 3);
        Olio o3 = new Olio("ITTP0312", "Linux-käyttäjärjestelmä", 5);
        Olio o4 = new Olio("ITTA0203", "Käyttäjärjestelmät", 2);
        Olio o5 = new Olio("IST2001", "Matemaattisten ohjelmistojen perusteet", 1);
       
        map.put(o1.getKoodi(), o1);
        map.put(o2.getKoodi(), o2);
        map.put(o3.getKoodi(), o3);
        map.put(o4.getKoodi(), o4);
        map.put(o5.getKoodi(), o5);
    }      
    
	public void hakuKoodilla(String kysyttyKoodi) {
		if(map.containsKey(kysyttyKoodi)) {
			System.out.println("Nimi: " + map.get(kysyttyKoodi).getNimi() + ", Laajuus: " + map.get(kysyttyKoodi).getLaajuus()+ "\n");
			
		} else {
			System.out.println("Virhe");
		}
	}
	
	public void hakuMerkkijonolla(String kysyttyNimi) {
		for(Olio loop:map.values() ) {
			
			if(loop.getNimi().contains(kysyttyNimi)) {
				System.out.println("Koodi: " + loop.getKoodi() + " Nimi: " + loop.getNimi() + ", Laajuus: " + loop.getLaajuus()+ "\n");
			}
		}
	}

	public void hakuLaajuudella(int kysyttyLaajuus) {
		for(Olio loop:map.values() ) {
			
			if(loop.getLaajuus() == (kysyttyLaajuus)) {
				System.out.println("Koodi: " + loop.getKoodi() + " Nimi: " + loop.getNimi() + ", Laajuus: " + loop.getLaajuus()+ "\n");
			}
		}
	}
}


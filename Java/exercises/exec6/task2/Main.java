package exec6.task2;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		
		
		ArrayList<Paivamaara> dates = new ArrayList<Paivamaara>();
		
		dates.add(new Paivamaara(01, 12, 1998));
		dates.add(new Paivamaara(07, 01, 1997));
		dates.add(new Paivamaara(01, 05, 1994));

		dates.add(new Paivamaara(11, 03, 2020));
		dates.add(new Paivamaara(15, 02, 2020));
		dates.add(new Paivamaara(25, 11, 2020));
		dates.add(new Paivamaara(26, 11, 2020));
		dates.add(new Paivamaara(25, 11, 2020));
		
		dates.add(new Paivamaara(01, 01, 2021));
		dates.add(new Paivamaara("06.12.1917"));
		
		Collections.sort(dates);
		
		for(Paivamaara d:dates){
			
			System.out.println(d.toString());
			}

	}

}

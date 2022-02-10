package exec4.task2;

import java.util.ArrayList;
import java.util.Scanner;
import hw1.Noppa;

public class Main {

	public static void main(String[] args) {
		
		Distribution distri = new Distribution(0,100);
		Scanner input = new Scanner(System.in);
			
			
		System.out.println("1:Arvosanat 2:Noppa");
		int valinta = input.nextInt();
		
		switch(valinta) {
	/*GRADE_METHOD--------------------------------------------------------*/
		case 1:
			
			ArrayList<Integer> graderooms = new ArrayList<>();
			System.out.println("Syätä arvosanoja. 99 lopettaa");
	
			int grades = 0;
			
			while (grades != 99) {
			grades = input.nextInt();
			graderooms.add(grades);
			distri.insertValue(grades);
			}
			
			Printer print1 = new Printer(distri);
			print1.print(distri);
			
			break;
			
	/*SIX-SIDE-DIE-METHOD--------------------------------------------------*/
		case 2:
			Noppa n1 = new Noppa();
			
			System.out.println("Kuinka monta kertaa noppaa heitetään?");
			int throwAmount = input.nextInt();
			
			for (int i = 0; i< throwAmount; i++) {
				
				int dieNumber = n1.getHeitto();
				System.out.println("Luku: " + dieNumber);
				distri.insertValue(dieNumber);
			}
			Printer print2 = new Printer(distri);
			print2.print(distri);
			
			break;
			
		default:	
			System.out.println("Komentoa ei ole olemassa \n");
		}
		input.close();
	}
}


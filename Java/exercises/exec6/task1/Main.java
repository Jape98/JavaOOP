package exec6.task1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Measurable> shapes = new ArrayList<Measurable>();
		
		/*---------Suorakulmio (x1,y1, x2,y2)---------*/
		shapes.add(new Suorakulmio(0,0,5,5));
		shapes.add(new Suorakulmio(1,1,4,6));
		shapes.add(new Suorakulmio(3,1,8,7));
		/*------------Ympyr√§ (x,y, radius)------------*/
		shapes.add(new Ympyr‰(1,1,1));
		shapes.add(new Ympyr‰(1,1,3));
		shapes.add(new Ympyr‰(2,2,5));
		
		
		Scanner input=new Scanner(System.in);
		
		System.out.println("Give scale value ");
		double scaleValue = input.nextDouble();
		
		System.out.println("\nOriginal values values:");

		for(Measurable sh:shapes){
			System.out.println("Area: " + Math.round(sh.area()*100.0)/100.0 + " Perimeter: " + Math.round(sh.perimeter()*100.0)/100.0);
			}
		
		System.out.println("\nScaled values:");
		
		for(Measurable sh:shapes){
			sh.scale(scaleValue);
			System.out.println("Area: " + Math.round(sh.area()*100.0)/100.0 + " Perimeter: " + Math.round(sh.perimeter()*100.0)/100.0);
			}
		
		input.close();
	}

}

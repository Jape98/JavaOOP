package exec1.task1;
import java.util.Scanner;

public class A 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number 1: ");
		int number1 = input.nextInt();
		
		System.out.println("Enter a number 2: ");
		int number2 = input.nextInt();

			if(number1 > number2)
			{
				System.out.println(number1 + " is greater than " + number2);
			}
			else 
			{
				System.out.println(number2 + " is greater than " + number1);
			}
		input.close();
	}
}

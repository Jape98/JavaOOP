package exec1.task1;
import java.util.Scanner;

public class B 
{
	public static void main(String[] args)
	{
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("How many names do you want to enter?");
		int amount = input.nextInt();
		
		String[] name = new String[amount];
		
		input.nextLine(); //poistaa rivinvaihdon syättäpuskurista
		
		System.out.println("Enter a name");
		
			for(int i=0; i<amount; i++)
			{
				name[i] = input.nextLine();
			}
			for(int i=0; i<amount; i++)
			{
				System.out.println(i+1+". "+name[i]);
			}
			
			/* Tai toisella tavalla
			for(String apu: name)
			{
				System.out.println(apu);
			}
			*/
			
		input.close();
	}
}


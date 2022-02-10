package exec1.task2;

public class SarmioMain {

	public static void main(String[] args)
		{
			/*Sarmio(leveys, korkeus, pituus);*/
			Sarmio s1 = new Sarmio(5,5,2);
			Sarmio s2 = new Sarmio(1, 2, 3);
			
			
			System.out.println("Korkeus: " + s1.getKorkeus()+ " Leveys: " + s1.getLeveys() + " Pituus: " + s1.getPituus() + "\nTilavuus: " + s1.tilavuus() +"\n");
			System.out.println("Korkeus: " + s2.getKorkeus()+ " Leveys: " + s2.getLeveys() + " Pituus: " + s2.getPituus() + "\nTilavuus: " + s2.tilavuus() +"\n");
		}

}

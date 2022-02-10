package exec5.task1;

public class UmpiSarmioMain {

	public static void main(String[] args) {
		
		UmpiSarmio s1 = new UmpiSarmio(5,5,5,2);
		UmpiSarmio s2 = new UmpiSarmio(3,3,3,5);

		System.out.println("Korkeus: " + s1.getKorkeus()+ " Leveys: " + s1.getLeveys() + " Pituus: " + s1.getPituus() + " Tiheys: " + s1.getTiheys() + "\nTilavuus: " + s1.tilavuus() +"\nMassa: " +s1.massa()+"\n");
		System.out.println("Korkeus: " + s2.getKorkeus()+ " Leveys: " + s2.getLeveys() + " Pituus: " + s2.getPituus() + " Tiheys: " + s2.getTiheys() + "\nTilavuus: " + s2.tilavuus() +"\nMassa: " +s2.massa()+"\n");
		
	}

}

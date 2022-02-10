package hw1;

public class Main {

	public static void main(String[] args){
	
		Noppa n1 = new Noppa();
		Noppa n2 = new Noppa();
		
		int numero1 = 0;
		int numero2 = 1;
		
		while (numero1 != numero2) {
			numero1 = n1.getHeitto();
			numero2 = n2.getHeitto();
			
			if (numero1 != numero2) {
				System.out.println("Eri silmäluku: " + numero1 +" ja "+ + numero2);
			}else{
				System.out.println("Sama silmäluku: " + numero1 +" ja "+ + numero2);
			}	
	    }
	}
}

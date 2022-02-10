package exec1.task3;

public class Tilaus {

	private String tuote;
	private double hinta, maara;
	
		
	/*----------------------------------------------*/
	public double getHinta() {
	       return hinta;
	   }

	   public void setHinta(double a) {
	       hinta = a;
	   }
/*----------------------------------------------*/
	   public double getMaara() {
	       return maara;
	   }

	   public void setMaara(double b) {
	       maara = b;
	   }
/*----------------------------------------------*/
	   public String getTuote() {
	       return tuote;
	   }

	   public void setTuote(String c) {
	       tuote = c;
	   }
/*----------------------------------------------*/
	   public double yhteensa() {
			return (maara*hinta);
		}

}




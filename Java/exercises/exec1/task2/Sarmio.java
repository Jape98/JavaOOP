package exec1.task2;

public class Sarmio {
	
	public double leveys, pituus, korkeus;

/*Constructor-----------------------------------*/
    public Sarmio(double leveys, double korkeus, double pituus){
        this.leveys=leveys;
        this.korkeus=korkeus;
        this.pituus=pituus;
    }
    
/*Setters&Getters-------------------------------*/
	public double getKorkeus() {
	       return korkeus;
	   }

	   public void setKorkeus(double a) {
	       korkeus = a;
	   }
/*----------------------------------------------*/
	   public double getLeveys() {
	       return leveys;
	   }

	   public void setLeveys(double b) {
	       leveys = b;
	   }
/*----------------------------------------------*/
	   public double getPituus() {
	       return pituus;
	   }

	   public void setPituus(double c) {
	       pituus = c;
	   }
/*----------------------------------------------*/
	public double tilavuus() {
		return (leveys*pituus*korkeus);
	}
}
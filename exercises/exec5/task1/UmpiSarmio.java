package exec5.task1;
import exec1.task2.Sarmio;

public class UmpiSarmio extends Sarmio {
    
    private double tiheys;
    
    public UmpiSarmio (double leveys, double korkeus, double pituus, double tiheys){
    	
        super(leveys, korkeus, pituus);
        this.tiheys=tiheys;
    }
   
    public double getTiheys() {
	       return tiheys;
	   }
    
    public double massa(){
        return super.tilavuus()*this.tiheys;
    }
    
}

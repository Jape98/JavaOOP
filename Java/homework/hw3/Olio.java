package hw3;

public class Olio {
	
    private String koodi, nimi;
    private int laajuus;

    
    public Olio(String koodi, String nimi, int laajuus){
    	
        this.koodi = koodi;
        this.nimi = nimi;
        this.laajuus = laajuus;
    }

    public String getKoodi() {
        return koodi;
    }

    public String getNimi() {
        return nimi;
    }

    public int getLaajuus() {
        return laajuus;
    }
	
}

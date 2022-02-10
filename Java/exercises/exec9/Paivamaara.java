package exec9;
public class Paivamaara implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2209797225102243380L;

	private int paiva, kuukausi, vuosi;
	
	public static final String[] KUUKAUDET= {"tammikuu", "helmikuu", "maaliskuu", "huhtikuu", "toukokuu", "kesäkuu", "heinäkuu", "elokuu", "syyskuu", "lokakuu", "marraskuu", "joulukuu"};
	
/*---------------------Constructors--------------------*/
	public Paivamaara() {
		java.time.LocalDate tanaan= java.time.LocalDate.now();
		paiva= tanaan.getDayOfMonth();
		kuukausi= tanaan.getMonthValue();
		vuosi= tanaan.getYear();
	}
	
	public Paivamaara(int paiva2,int kuukausi2 ,int vuosi2) {
		paiva = paiva2;
		kuukausi = kuukausi2;
		vuosi = vuosi2;
	}
	
	public Paivamaara(String strPaiva) {
		paiva = Integer.parseInt (strPaiva.substring(0,2));
		kuukausi = Integer.parseInt (strPaiva.substring(3,5));
		vuosi = Integer.parseInt (strPaiva.substring(6,10));
	}
	
/*-----------------Getterit-&-Setterit-----------------*/
	
	/*---Päivä---*/
	public int getPaiva() {
		return paiva;
	}

	public void setPaiva(int paiva) {
		this.paiva = paiva;
	}
	/*---Kuukausi---*/
	public int getKuukausi() {
		return kuukausi;
	}

	public void setKuukausi(int kuukausi) {
		this.kuukausi = kuukausi;
	}
	/*---Vuosi---*/
	public int getVuosi() {
		return vuosi;
	}

	public void setVuosi(int vuosi) {
		this.vuosi = vuosi;
	}
	
/*----------------------------Muuta----------------------*/
	

	public String toString() {
		return paiva + "." + kuukausi + "." + vuosi;
	}
	
	public String toLongString() {
		return paiva +". "+  KUUKAUDET[kuukausi-1] +" "+ vuosi;
	}
	
	public boolean onSama(Paivamaara toinen) {
		
		if (paiva == toinen.paiva && kuukausi == toinen.kuukausi && vuosi == toinen.vuosi) {
			return true;
			
		}else{
			return false;
		}
		
	}
	/*Metodi, joka palauttaa kuukauden nimeä vastaavan kuukauden taulukosta*/
	public static int kuukaudenNumero(String kuukaudennimi) {
		
		for(int i=0; i<12; i++ ){
				
			if (kuukaudennimi.equalsIgnoreCase(KUUKAUDET[i])) {
				return i+1;
			}
		}
		return -1;
	}
}	
	
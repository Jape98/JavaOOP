package exec7.task1;

public class Calculation {

	private String u,r,i;
	private double Di,Dr,Du;
	
	public Calculation(String u, String r, String i) {
		
		this.u = u;
		this.r = r;
		this.i = i;
	}
	
    public String voltage(){
		
		Di = Double.parseDouble(i);
		Dr = Double.parseDouble(r);
		
		double u = Di*Dr;
		
		return Double.toString(u);
		
	}
	
	public String current(){
				
		Du = Double.parseDouble(u);
		Dr = Double.parseDouble(r);
		
		double i = Du/Dr;
		
		return Double.toString(i);
				
	}
	
	public String resistance(){
		
		Du = Double.parseDouble(u);
		Di = Double.parseDouble(i);
		
		double r = Du/Di;
		
		return Double.toString(r);
	}
}

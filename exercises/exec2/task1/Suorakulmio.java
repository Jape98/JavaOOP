package exec2.task1;

public class Suorakulmio {
	
	private double x1,x2,y1,y2;
	//private double korkeus, kanta;
	
	public Suorakulmio() {
		x2 = 1;
		y2 = 1;
	}
	
	public Suorakulmio(double _x2, double _y2) {
		x2 = _x2;
		y2 = _y2;
	}
	
	public Suorakulmio(double _x, double _y, double _x2, double _y2) {
		x2 = _x2;
		y2 = _y2;
		x1= _x;
		y1= _y;
		
	}
/*----------------------------------------------------*/
	
	public double kanta() {
		return x2 - x1;
	}
	public double korkeus() {
		return y2 - y1;
	}
	public double pintaAla() {
		return kanta() * korkeus();
	}
}

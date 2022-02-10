package exec6.task1;

public class Suorakulmio implements Measurable  {
	
	private double x1,x2,y1,y2;
	
	public Suorakulmio() {
		x2 = 1;
		y2 = 1;
	}
	
	public Suorakulmio(double _x2, double _y2) {
		x2 = _x2;
		y2 = _y2;
	}
	
	public Suorakulmio(double _x, double _y, double _x2, double _y2) {
		x1= _x;
		x2= _x2;
		y1 = _y;
		y2 = _y2;
	}
/*----------------------------------------------------*/
	
	public double width() {
		return x2 - x1;
	}
	
	public double height() {
		return y2 - y1;
	}
	
	public double area() {
		return width() * height();
	}

	public double perimeter() {
		return (height()*2) + (width()*2);
	}

	public void scale(double scaleValue) {
		x2 = x1 + scaleValue * width();
		y2 = y1 + scaleValue * height();
	}
}

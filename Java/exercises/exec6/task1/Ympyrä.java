package exec6.task1;

public class Ympyrä implements Measurable {

    @SuppressWarnings("unused")
	private double x, y, radius; 

    
    public Ympyrä(double x, double y, double radius) {
    	this.x = x;
    	this.y = y;
    	this.radius = radius;
    }
    
    public double area() {
        return Math.PI * radius * radius;
    }

	@Override
	public double perimeter() {
		return 2 * Math.PI * radius;
	}

	public void scale(double scaleValue) {
		radius = radius*scaleValue;
	}
}

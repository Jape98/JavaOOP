package hw2;

public class Fraction {

    private int numerator;
    private int denominator;

    public Fraction() { //Parametriton konstruktori
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int _numerator, int _denominator) {
    	
        numerator = _numerator;
        denominator = _denominator;
        
        if(denominator == 0) {
            denominator = 1;  
        }
    }

    public String toString() {
        return numerator + "/" + denominator;
    }

    public double toDouble() {
        return (double)numerator/denominator;
    }
    
    public Fraction multiply(Fraction multiplier){
        
       	int newNumerator = numerator * multiplier.numerator;
        int newDenominator = denominator * multiplier.denominator;
        Fraction frNew = new Fraction(newNumerator, newDenominator);
        
        return frNew;
    }
}

package hw2;

public class Main {

    public static void main(String[] args) {
        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction(2,3);
        
        System.out.println(f1.toString());
        System.out.println(f1.toDouble());
        System.out.println(f2.toString());
        System.out.println(f2.toDouble());
        
        Fraction a = new Fraction(3, 4);
        Fraction b = new Fraction(2, 5);
        Fraction c = a.multiply(b);
        System.out.println(c.toString());

    }

}
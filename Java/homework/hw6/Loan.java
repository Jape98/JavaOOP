package hw6;

public class Loan {

	private int year;
	private double amount, interestRate, installment;

	public Loan(String amount, String interestRate, String year){
		
		this.year = Integer.parseInt(year);
		this.amount = Double.parseDouble(amount);
		this.interestRate = Double.parseDouble(interestRate);	
	}
	
	public Loan(int year){
		
		this.year = year;
	}


	public double getAmount() {

		return amount;
	}
	
	public double GetRepayment() {
		
		return amount/year;
	}
	
	
	public double GetInstallment(){
		
		return installment;
	}
	
	public double GetInterestRate() {
		
		return interestRate;
	}
	
	public String toString() {
		
		return "Start values --> " + "Loan amount (ä): " + amount + ", Interest rate (%): " + interestRate + ", Period (years): " + year;
	}
	
}

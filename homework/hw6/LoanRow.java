package hw6;

public class LoanRow {

	private int year;
	private double repayment, interest, installment, remaining;

	
	public LoanRow(int year, double repayment, double interest, double installment, double remaining){
		this.year = year;
		this.repayment = repayment;
		this.interest = interest;
		this.installment = installment;
		this.remaining = remaining;

		
	}
	
	public int getYear() {
		return year;
	}

	public double getRepayment() {
		return repayment;
	}

	public double getInterest() {
		return interest;
	}

	public double getInstallment() {
		return installment;
	}

	public double getRemaining() {
		return remaining;
	}
	
	public String toString() {
		
		return "Year: " + getYear() + ", Repayment: " + getRepayment() + ", Interest: " + getInterest() + ", Installment: " + getInstallment() + ", Remaining: " + getRemaining();
	}
	
}

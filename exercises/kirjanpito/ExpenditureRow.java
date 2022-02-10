package kirjanpito;

public class ExpenditureRow{

	Paivamaara date;
	private String category, description;
	private double amount;
	
	public ExpenditureRow(Paivamaara date, String category, double amount, String description) {
		
		this.date = date;
		this.category = category;
		this.amount = amount;
		this.description = description;
	}

	public Paivamaara getDate() {
		return date;
	}

	public String getCategory() {
		return category;
	}

	public String getDescription() {
		return description;
	}

	public double getAmount() {
		return amount;
	}

	public String toString() {
		return "date=" + date + ", category=" + category + ", description=" + description + ", amount=" + amount;
	}
}


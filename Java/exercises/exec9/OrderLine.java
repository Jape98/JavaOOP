package exec9;

public class OrderLine implements java.io.Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6666781496098956961L;
	private String product;
    private double price;
    private int quantity;
    
/*Product-set-get--------------------------------------*/
    
    public OrderLine(String product, double price, int quantity) {
    	this.product = product;
    	this.price = price;
    	this.quantity = quantity;
	}

	public void setProduct(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }
    
/*Price-set-get---------------------------------------*/
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }
    
/*Quantity-set-get--------------------------------------*/
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public double getQuantity() {
        return quantity;
    }
    
/*Others------------------------------------------------*/
    
    //Calculates sum of product prices
    public double sum() {
        return (price*quantity);
    }
}
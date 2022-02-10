package exec4.task1;

public class OrderLine {

    private String product;
    private double price, quantity;
    
/*Product-set-get--------------------------------------*/
    
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
    
    public void setQuantity(double quantity) {
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
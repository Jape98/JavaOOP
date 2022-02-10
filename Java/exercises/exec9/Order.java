/**/package exec9;

import java.util.ArrayList;

public class Order implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6215706854727799843L;
	private int orderId;
    private String customerName;
    private Paivamaara p1;
    
    ArrayList<OrderLine> products = new ArrayList<OrderLine>();

    public Order(int orderId, String customerName, Paivamaara orderdate) {

        this.orderId = orderId;
        this.customerName = customerName;
        
        p1 = orderdate;
        
    }
    
/*--------------------------------------------------------------------------------------------*/
    public void newOrderLine(String product, double price, int quantity) {
    	
        OrderLine orderline = new OrderLine(product, price, quantity);
        
        orderline.setProduct(product);
        orderline.setPrice(price);
        orderline.setQuantity(quantity);
        
        products.add(orderline);
    }
    
    /*--------------------------------------------------------------------------------------------*/
    public double totalPrice() {
        double totalprice = 0;
        for(OrderLine line: products) {
        	
            totalprice += line.sum();
        }
        return totalprice;
    }
    
    /*--------------------------------------------------------------------------------------------*/
    public String toString() {

        StringBuilder orderDetails = new StringBuilder();

        orderDetails.append("------------------------------------------------------\n");
        orderDetails.append("Order Id: " + orderId + "\n");
        orderDetails.append("Customer Name: " + customerName + "\n");
        orderDetails.append("Order Date: " + p1 + "\n\n");
        orderDetails.append("Product:	"+"Price:	"+"Amount:	"+"Total price:"+"\n");

        for (int i=0; i < products.size(); i++) {
        	
            orderDetails.append(products.get(i).getProduct() + "\t");
            orderDetails.append(products.get(i).getPrice() + "\t");
            orderDetails.append(products.get(i).getQuantity() + "\t");
            orderDetails.append(products.get(i).sum() + "\n");
        }
        orderDetails.append("\nTotal price: " + this.totalPrice() + "ä");
        orderDetails.append("\n-----------------------------------------------------\n\n");
        
        return orderDetails.toString();
    }

	public Integer getOrderID() {
		return orderId;
	}
	public void setOrderID(int id) {
		this.orderId = id;
	}
}
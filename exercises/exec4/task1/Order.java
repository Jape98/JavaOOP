/**/package exec4.task1;

import exec2.task2.Paivamaara;
import java.util.ArrayList;

public class Order {

    private int orderId;
    private String customerName;
    private Paivamaara p1;
    
    ArrayList<OrderLine> products = new ArrayList<OrderLine>();

    public Order(int orderId, String customerName, String paivamaara) {

        this.orderId = orderId;
        this.customerName = customerName;
        
        p1 = new Paivamaara(paivamaara);
        
    }
    
/*--------------------------------------------------------------------------------------------*/
    public void newOrderLine(String product, double price, double quantity) {
    	
        OrderLine orderline = new OrderLine();
        
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
}
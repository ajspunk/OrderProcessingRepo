package Order;

import java.util.concurrent.atomic.AtomicInteger;


//Order Class for the model
public class Order {
	
	//Sequence variable for the order numbers increment
	private static AtomicInteger seq = new AtomicInteger(0);
	//Order contents 
	private int orderNo;
	private String orderState;
	
	public Order(){
		
		orderNo = seq.incrementAndGet();  // Initializing the sequence for the threads 
		orderState = "NEW";				 // Initializing the order with state NEW
	}

	
	
	//Getters and Setters
	public  int getOrderNo() {
		return orderNo;
	}

	public  void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getOrderState() {
		return orderState;
	}

	public void setOrderState(String orderState) {
		this.orderState = orderState;
	} 
	
	//Getters and Setters

}

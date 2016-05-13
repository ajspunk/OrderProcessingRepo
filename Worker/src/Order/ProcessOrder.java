package Order;
import java.util.Date;
import java.util.concurrent.*;


// This class will process the queue and FULLFILL the orders
public class ProcessOrder implements Runnable{
		
	private BlockingQueue<Order> q = null;
	
	public ProcessOrder(BlockingQueue<Order> q) {
		
		this.q = q;
	}
	
	@Override
	public void run() {

		try {							
			Order o = q.take();	    		// Taking out the first order in the queue 
			o.setOrderState("FULFILLED");   // Making the order FULFILLED by processing it
			System.out.println(new Date() +" Order processed with ID: "+o.getOrderNo()+" and Processed State: "+o.getOrderState());
			} catch (InterruptedException e) {
			System.out.println("The processor threads were interrupted..");
			e.printStackTrace();
		}

	}
}

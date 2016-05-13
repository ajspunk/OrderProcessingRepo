package Work;
import java.util.*;
import java.util.concurrent.*;

import Order.*;

public class Worker {
	
	//Order List to track the orders generated
	private List<Order> orders =new ArrayList<Order>(10);
	
	public void run() throws InterruptedException{
		
		//Queue to store the order for processing
		BlockingQueue<Order> queue = new ArrayBlockingQueue<Order>(5);
		//Thread pools for the concurrent processing
		ExecutorService executor = Executors.newFixedThreadPool(10);
		
		//Iterating for the orders to create
		for(int i=0;i<10;i++){
			executor.execute(new Runnable(){
				/*Initializing the orders and putting in the queue asynchronously and 
				subsequently initiating the concurrent processing*/
				public void run(){			
			Order o = new Order();
			
			try {
				queue.put(o);			// Add order object in the queue
				orders.add(o);			// adding the order objects to the order tracking list
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(new Date() + " New Order generated with ID: "+o.getOrderNo()+" and State: "+o.getOrderState());
			
			//Initializing the order processing of the subsequent order with a new thread for concurrent processing
			new Thread(new ProcessOrder(queue)).start();	
				}});
		}
		
		//checking the processing status of the orders
		int stop=0;		//flag to check the order process status
		while(stop==0){			
			int unprocessedOrders=0;  // Variable indicating the orders in progress
			Thread.sleep(5);
		for(Order o1:orders){
			if(o1.getOrderState().equals("NEW"))
					unprocessedOrders++;   // counting the current unprocessed orders 
		}		
		//checking if orders are FULFILLED
		if(unprocessedOrders==0){
			System.out.println("All orders are FULFILLED.!");	
			stop=1;}
		else{
			System.out.println("Orders unprocessed : "+unprocessedOrders);
		}				
		}
		//shutting down the executor service for the thread pools
		executor.shutdown();
		//waiting for the termination of the service
		executor.awaitTermination(1, TimeUnit.SECONDS);
	}
	}
				
		
		
		
		
	

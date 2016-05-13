package Work;

public class WorkTester {
		 /*** The main method of this tester class* @param args
		 * @throws InterruptedException */

	     public static void main(String[] args) throws InterruptedException {
	         
	    	 //Invoking the Order Processor Worker class  
	    	 System.out.println("Starting the process of testing Worker class..");
	    	 Worker aWorker = new Worker();
	    	 //Invoking the worker class with the designated run method
	         aWorker.run();
	           
	     }


}

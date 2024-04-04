package Java_Practice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
	
	public static void main(String[] args) {
		
		ExecutorService executorService = Executors.newFixedThreadPool(5);
		
		for(int i=1; i<=5; i++) {
			
			Runnable runnable1=new MyRunnable("My Runnable Thread :" + i);
		//	Runnable runnable2=new MyThread("MYThread class Thread :" + i);
			
		/*
		 * Thread thread=new Thread(runnable2);
		 * 
		 * thread.setPriority(Thread.MAX_PRIORITY);
		 */
			
			executorService.execute(runnable1);
		//	executorService.execute(thread);
			
		}
		
		while(!executorService.isTerminated()) {
			
		}
		
		System.out.println("Successfully Done");
		
		executorService.shutdown();
	}

}

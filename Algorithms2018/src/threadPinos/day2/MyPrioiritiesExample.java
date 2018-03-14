package threadPinos.day2;

class ThreadFunny implements java.lang.Runnable {
	
	volatile boolean running = true;
	long i = 0;
	Thread t;
	String funny = "";
	
	ThreadFunny (int priority, String s) {
		t = new Thread (this);
		t.setPriority(priority);
		funny = s;
	}
	void stop () {
		running = false;
	}
	
	void start() {
		t.start();
	}
	
	//ThreadFunny 
	@Override
	public void run () {
		while (running) {
			System.out.print(funny);
			i++;
		}
	}
}
public class MyPrioiritiesExample {

	public static void main(String[] args) {
		ThreadFunny tf1 = new ThreadFunny (Thread.MIN_PRIORITY, ".");
		ThreadFunny tf2 = new ThreadFunny (Thread.MAX_PRIORITY, "X");
		
		tf1.start();
		tf2.start();
		
		try {
		Thread.sleep(1000);

		tf1.stop();
		tf2.stop();

			tf1.t.join();
			tf2.t.join();
		}
		catch (InterruptedException ie) {
			System.out.println ("oops...");
		}
		
		System.out.println("\n" + tf1.i + " vs. " + tf2.i);

	}

}

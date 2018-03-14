package threadPinos.day2;

public class NewThread implements java.lang.Runnable {

	String name;
	java.lang.Thread t;

	NewThread (String threadName){
		name = threadName;
		t = new java.lang.Thread (this, name);
		System.out.println("Comenzamos con " + t);
		t.start();
	}

	@Override
	public void run () {
		try {
			for(int i = 5; i > 0; i--) {
				System.out.println(name + ": " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println(name + " interrupted.");
		}
		System.out.println("Bye!");
	}
	public static void main(String[] args) {
		NewThread ob1 = new NewThread( "One");
		NewThread ob2 = new NewThread( "Two");
		NewThread ob3 = new NewThread( "Three");

		System.out.println("ob1 is alive? " + ob1.t.isAlive());
		System.out.println("ob2 is alive? " + ob2.t.isAlive());
		System.out.println("ob3 is alive? " + ob3.t.isAlive());

		// wait for threads to finish
		try {
			System.out.println("Waiting for threads to finish.");
			ob1.t.join();
			ob2.t.join();
			ob3.t.join();
		} catch (InterruptedException e) {
			System.out.println("Main thread Interrupted");
		}
		System.out.println("Thread One is alive: "
				+ ob1.t.isAlive());
		System.out.println("Thread Two is alive: "
				+ ob2.t.isAlive());
		System.out.println("Thread Three is alive: "
				+ ob3.t.isAlive());
		System.out.println("Main thread exiting.");

	}

}

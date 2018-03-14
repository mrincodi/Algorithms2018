package threadPinos.day2;

class JustARunnable implements java.lang.Runnable {
	public void run() {
		
		String myName = java.lang.Thread.currentThread().getName();
		try {
			
			for ( int i = 0; i < 100; i++) {
				System.out.println("Runnable kid here (" + myName + ")! " + i);
				java.lang.Thread.sleep(10);
			}
		}
		catch (java.lang.InterruptedException ie) {
			System.out.println("Oops!" + ie);
		}
	}
}

class ImAThreadBiatch extends java.lang.Thread {

	// If I define the variable here, it will take the name "main".
	// There is not an actual new thread until the "run" method is ran.
	//String myName = java.lang.Thread.currentThread().getName();
	
	
	@Override
	public void run() {
		String myName = java.lang.Thread.currentThread().getName();
		try {
			for ( int i = 0; i < 100; i++ ) {
				System.out.println("Well, this is the thread talking (" + myName + ") " + i);
				java.lang.Thread.sleep(10);
			}
		}
		catch (java.lang.InterruptedException ie) {
			System.out.println("Oops! " + ie);
		}
	}
}


public class AnotherThreadsExercise {

	public static void main(String[] args) {
		java.lang.Thread thread1 = new java.lang.Thread ( new JustARunnable(), "runnin' runnin'");
		java.lang.Thread thread2 = new ImAThreadBiatch();
		thread2.setName("Thread or THREATH??");
		
		thread1.start();
		thread2.start();
		

	}

}

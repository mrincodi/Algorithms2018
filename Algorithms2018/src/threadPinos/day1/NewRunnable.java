package threadPinos.day1;

public class NewRunnable implements java.lang.Runnable {
	public void run (){
		String nombre = java.lang.Thread.currentThread().getName();

		try {
			for ( int i = 0; i < 10; i++){
				System.out.println ("OK, soy " + nombre + " y voy por el " + i );
			}
			Thread.sleep(10);
		}
		catch (java.lang.InterruptedException ie) {
			System.out.println(ie);
		}
	}

	public static void main ( String [] args ){
		new java.lang.Thread ( new NewRunnable(), "juanito").start();
		new java.lang.Thread ( new NewRunnable(), "pepito").start();
	}
}
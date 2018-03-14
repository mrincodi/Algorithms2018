package threadPinos.day1;
class CurrentThreadDemo {
	public static void main ( String [] args ){
		Thread elThread = java.lang.Thread.currentThread();
		System.out.println ("el thread: " + elThread );
		java.lang.Thread.currentThread().setName("Pepito");
		elThread = java.lang.Thread.currentThread();
		System.out.println ("el thread: " + elThread );

		try {
			for ( int i = 0; i < 5; i++ ){
				java.lang.Thread.sleep (1000);
				System.out.println (i);
			}
		}
		catch ( java.lang.InterruptedException ie ){
			// Why doesn't this complain when I interrupt with a ctrl-c?
			System.out.println ( "Oops...\n"  + ie); 
		}
	}
}

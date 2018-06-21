package threadPinos.again;


class PseudoThread extends Thread {
	public void run (){
		for ( int i = 0; i < 100; i++){
			System.out.println("Hello " + i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class PseudoThread2 implements Runnable {
	@Override
	public void run (){

		for ( int i = 0; i < 100; i++){
			System.out.println("It's me " + i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class SeraThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PseudoThread pt = new PseudoThread ();
		pt.start();
		new Thread( new PseudoThread2()).start();
		for ( int i = 0; i < 100; i++){
			System.out.println("Bye " + i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

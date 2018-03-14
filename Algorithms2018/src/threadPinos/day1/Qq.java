package threadPinos.day1;

class Sera implements Runnable {

	@Override
	public void run() {
		System.out.println("Hola desde el Thread.");
	}
	
}
public class Qq {

	public static void main(String[] args) {
		new Thread(new Sera()).start();

		System.out.println("Hey");

	}

}

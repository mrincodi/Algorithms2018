package threadPinos.day1;
class NewThread extends java.lang.Thread {

	NewThread (String nombre){
		this.setName(nombre);
		this.start();
	}

	@Override
	public void run (){
		try {
			for ( int i = 0; i < 10; i++ ){
				System.out.println ( "Hola. Soy " + this.getName() + " y voy por el " +  i);
				java.lang.Thread.sleep(10);
			}
		}
		catch (java.lang.InterruptedException ie ){
			System.out.println ( "Oops...");
		}
	}

}

public class NewThreadExercise {
	public static void main ( String [] args){

		new NewThread ("juanito");
		new NewThread ("juanito"); // I can create threads with the same name!!

		try {
			for ( int i = 0; i < 10; i++ ){
				System.out.println ( "Hola. Soy " + java.lang.Thread.currentThread().getName() + " y voy por el " +  i);
				java.lang.Thread.sleep(10);
			}
		}
		catch (java.lang.InterruptedException ie ){
			System.out.println ( "Oops...");
		}
	}
}
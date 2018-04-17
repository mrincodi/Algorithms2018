package design_patterns.singleton;

public class Singleton {
	private static Singleton s = new Singleton ();
	private Singleton (){};
	
	public static Singleton getInstance(){
		return s;
	}
	
	public void showMessage (){
		System.out.println("Well, well, well...");
	}
}

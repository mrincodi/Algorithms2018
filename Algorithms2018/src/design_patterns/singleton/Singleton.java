package design_patterns.singleton;

public class Singleton {
	private static Singleton s = new Singleton ();
	
	//Optional: Initialize with null:
	//private static Singleton s;
	
	private Singleton (){};
	
	public static Singleton getInstance(){
		
		//If initialized with null:
		//if ( s == null ) s = new Singleton ();
		return s;
	}
	
	public void showMessage (){
		System.out.println("Well, well, well...");
	}
}

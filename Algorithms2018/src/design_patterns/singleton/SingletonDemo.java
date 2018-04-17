package design_patterns.singleton;

public class SingletonDemo {

	public static void main(String[] args) {
		Singleton s = Singleton.getInstance();
		
		s.showMessage();
	}

}

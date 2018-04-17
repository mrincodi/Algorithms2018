package design_patterns.singleton2;

public class SingleObject {

	private static SingleObject so = new SingleObject();
	String message = "papas";
	
	private SingleObject (){
	};
	
	public static SingleObject getObject (){
		return so;
	}
	
	public void showMessage (){
		System.out.println(message);
	}
	
	public static void main(String[] args) {
		SingleObject so = SingleObject.getObject();
		so.showMessage();
	}

}

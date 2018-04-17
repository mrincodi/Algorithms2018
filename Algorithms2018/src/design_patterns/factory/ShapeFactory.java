package design_patterns.factory;

public class ShapeFactory {

	public Shape getShape ( String s){
		
		if ( s.equalsIgnoreCase( "CIRCLE"))
			return new Circle ();
		else if ( s.equalsIgnoreCase( "RECTANGLE"))
			return new Rectangle ();
		else if ( s.equalsIgnoreCase( "SQUARE")) 
			return new Square ();
		else
			return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

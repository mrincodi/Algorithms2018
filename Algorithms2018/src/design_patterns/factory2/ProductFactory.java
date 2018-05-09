package design_patterns.factory2;

public class ProductFactory {

	int CAPUCCINO=1;
	int FRAPUCCINO=2;
	
	public Product createNewProduct (Productos p){
		switch (p){
		case CAPUCCINO:
			return new Capuccino();
		case FRAPUCCINO:
			return new Frapuccino();
		case HOT_CHOCOLATE:
			return new HotChocolate();
		
			default:
				return null;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

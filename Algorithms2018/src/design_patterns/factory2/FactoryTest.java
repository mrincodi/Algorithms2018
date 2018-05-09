package design_patterns.factory2;

public class FactoryTest {

	public static void main(String[] args) {
		ProductFactory pf = new ProductFactory();
		
		Product capuccino = pf.createNewProduct(Productos.CAPUCCINO);

		System.out.println( capuccino.getPrice());
	}

}

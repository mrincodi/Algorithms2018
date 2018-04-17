package design_patterns.factory.myExample;

public class PolarAnimalTest {

	public static void main(String[] args) {
		PolarAnimalFactory paf = new PolarAnimalFactory();
		
		PolarAnimal aBeautifulPenguin = paf.create("penguin");
		
		aBeautifulPenguin.makeSound();

	}

}

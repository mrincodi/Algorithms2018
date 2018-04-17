package design_patterns.factory.myExample;

public class PolarAnimalFactory {
	public PolarAnimal create (String what){
		if ( what.equalsIgnoreCase("Penguin"))
			return new Penguin();
		if ( what.equalsIgnoreCase("PolarBear"))
			return new PolarBear();
		if ( what.equalsIgnoreCase("Seal"))
			return new Seal();
		
		return null;
	}
}

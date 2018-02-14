package pinos;

public class PinoEnum2 {

	PinoEnum qq;
	
	PinoEnum2(PinoEnum letter){
		this.qq=letter;
		System.out.println( qq);
	}
	public static void main(String[] args) {
		PinoEnum2 testing = new PinoEnum2 ( PinoEnum.ALPHA);
		//System.out.println(testing.qq);
		if ( testing.qq == PinoEnum.ALPHA )
			System.out.println("Indeed, it's an alpha.");
		
		switch (testing.qq){
		case ALPHA:
			break;
		case BETA:
			break;
		case GAMMA:
			break;
		default:
			break;
			
		}

	}

}

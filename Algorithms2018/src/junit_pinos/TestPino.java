package junit_pinos;

public class TestPino {

	public int suma ( int x, int y){
		return x + y;
	}

	@org.junit.Test
	public void testOneThing() {
		org.junit.Assert.assertEquals(5,suma(2,3));
	}

	@org.junit.Test
	public void testSomethingElse (){
		org.junit.Assert.assertEquals(1, suma(2,-1));
	}

	public static void main(String[] args) {
		//Remember to have the option -ea for the VM for this to run!
		int a = 7;
		assert a == 7;
		//assert false;
	}

}

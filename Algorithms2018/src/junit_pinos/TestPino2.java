package junit_pinos;

import java.util.ArrayList;

public class TestPino2 {

	public int suma ( int x, int y){
		return x + y;
	}

	ArrayList < Integer> qq = new ArrayList < Integer> ();


	@org.junit.Before
	public void before(){
		System.out.println ( "Las luciérnagas no suelen salir de día.");
	}

	@org.junit.After
	public void after(){
		System.out.println ( "Smooooth operatah...");
	}
	
	
	@org.junit.Test
	@org.junit.Ignore
	public void veamos (){
		System.out.println ("Aquí vamos.");
		org.junit.Assert.assertEquals(5, 5);
	}

	@org.junit.Test(timeout=100)
	public void veamos2 (){
		System.out.println ("Aquí vamos de nuevo.");
		org.junit.Assert.assertEquals(5, 5);
	}

	public static void main(String[] args) {
		//Remember to have the option -ea for the VM for this to run!

		int pp = 55;

		assert pp == 55;


	}

}

package pinos;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArray {
	public void arrange(ArrayList<Integer> a) {
		ArrayList<Integer> result = new ArrayList<Integer> ();
		System.out.println(result.size());
		for ( int i = 0; i < a.size(); i++){
			result.set(i,a.get(a.get(i)));
		}
		for ( int i = 0; i < result.size(); i++){
			a.set(i,result.get(i));
		}
	}

	public static void main(String[] args) {
		ArrayList <Integer> aL = new ArrayList <Integer> (Arrays.asList(0,2,1,3));
		new RearrangeArray().arrange(aL);
		
	}

}

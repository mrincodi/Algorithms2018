package pinos;

import java.util.ArrayList;

public class AddOneToNumber {

	public ArrayList<Integer> plusOne(ArrayList<Integer> numberArray) {

		removeRightZeros(numberArray);

		ArrayList<Integer> result = plusOneOK (numberArray);
		return result;
	}

	public void removeRightZeros(ArrayList<Integer> numberArray){
		while (numberArray.size()>0){
			if (numberArray.get(0).equals(0))
				numberArray.remove(0);
			else
				return;
		}

		if ( numberArray.size() == 0 )
			numberArray.add(0);
	}

	public ArrayList<Integer> plusOneOK(ArrayList<Integer> numberArray) {
		ArrayList<Integer> result = new ArrayList<Integer> ();
		int carry = 1;
		for (int i = numberArray.size() - 1; i >=0; i--){
			int newDigit = numberArray.get(i)+carry;
			carry = newDigit / 10;
			newDigit = newDigit%10;

			result.add (0,newDigit);
		}
		if (carry == 1)
			result.add (0, 1);

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

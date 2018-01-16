package pinos;

// https://www.interviewbit.com/problems/integer-to-roman/

public class IntegerToRoman {

	public String intToRoman(int A) {

		StringBuffer sb = new StringBuffer ();

		int pos = 1;

		while ( A > 0){
			String numerals = "";
			int digit = A%10;
			A=A/10;

			String low="",mid="",high="";

			switch (pos){
			case 1:
				low="I";
				mid="V";
				high="X";
				break;

			case 2:
				low="X";
				mid="L";
				high="C";
				break;

			case 3:
				low="C";
				mid="D";
				high="M";
				break;

			case 4:
				low="M";
				break;

			default:
				break;
			}

			switch (digit){
			case 0:
				break;

			case 1:
				numerals = low;
				break;

			case 2:
				numerals = low + low;
				break;

			case 3:
				numerals = low + low + low;
				break;

			case 4:
				numerals = low + mid;
				break;

			case 5:
				numerals = mid;
				break;

			case 6:
				numerals = mid + low;
				break;

			case 7:
				numerals = mid + low + low;
				break;

			case 8:
				numerals = mid + low + low + low;
				break;

			case 9:
				numerals = low + high;
				break;

			default:
				break;
			}
			sb.insert (0,numerals);

			pos++;
		}
		return sb.toString ();
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

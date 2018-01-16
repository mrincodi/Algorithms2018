package pinos;

//https://www.interviewbit.com/problems/generate-all-parentheses/

public class GenerateAllParentheses {

	public int isValid(String A) {
		if ( A == null || A.length () <= 1 ) return 1;

		java.util.Stack <Character> stack = new java.util.Stack <Character> ();
		for (int i = 0; i < A.length();i++){
			char character = A.charAt(i);

			if ( character == '(' || character ==  '{' || character == '[' )
				stack.push ( character );
			else {
				if ( stack.size() == 0 ) return 0;

				char characterPopped = stack.pop();

				switch (character){
				case ')':
					if ( characterPopped != '(') return 0;
					break;

					case '}':
						if ( characterPopped != '{') return 0;
						break;

					case ']':
						if ( characterPopped != '[') return 0;
						break;

					default:
						break;
				}
			}
		}

		if (stack.size() != 0) return 0;

		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package pinos;

import java.util.ArrayList;
import java.util.Stack;

// https://www.interviewbit.com/problems/evaluate-expression/
	
public class EvalRPN {

	public int evalRPN(ArrayList<String> A) {

		if ( A == null || A.size() == 0) return 0;
		Stack <String> stack = new Stack <String>();

		for ( String s : A){
			stack.push (s);
		}

		int result = RPN (stack);

		return result;

	}

	int RPN (Stack <String> stack){
		int result = 0;
		String val = stack.pop();

		//TODO

		boolean isANumber = true;
		try{
			result = Integer.parseInt(val);
		}
		catch (Exception e){
			isANumber = false;
		}

		if (isANumber) return result;

		int operand1 = RPN (stack);
		int operand2 = RPN (stack);

		if (val.equals("+"))
			return operand2 + operand1;
		else if (val.equals("-"))
			return operand2 - operand1;
		else if (val.equals("*"))
			return operand2 * operand1;
		else 
			return operand2 / operand1;
		// I am supposing it''s well-formed
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}

package pinos;

import java.util.ArrayList;

public class MinStack {
	ArrayList <Integer> stack = new ArrayList <Integer> ();
	ArrayList <Integer> minimums = new ArrayList <Integer> ();

	int min = Integer.MAX_VALUE;

	public void push(int x) {
		min = Math.min(min,x);
		stack.add(x);
		if (stack.size() == 1 || minimums.get(minimums.size() - 1 )>=x){
			minimums.add(x);
		}
	}

	public void pop() {
		min = Integer.MAX_VALUE;
		if ( stack.size() > 0){
			int x = stack.remove (stack.size() - 1);

			if (minimums.get(minimums.size() - 1 )==x)
				minimums.remove(minimums.size() - 1);
		}
	}

	public int top() {
		if ( stack.size() == 0)
			return -1;
		else
			return stack.get (stack.size() - 1);
	}

	public int getMin() {
		if ( stack.size() == 0)
			return -1;
		else
			return minimums.get(minimums.size() - 1 );
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

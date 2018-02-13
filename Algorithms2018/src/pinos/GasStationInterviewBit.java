package pinos;

import java.util.List;

//https://www.interviewbit.com/problems/gas-station/
//O(n) approach

public class GasStationInterviewBit {

	public int canCompleteCircuit(final List<Integer> gas, final List<Integer> cost) {
		int remaining = 0;
		int start = 0;
		int tank = 0;

		for(int i = 0; i < gas.size(); ++i) {
			tank += gas.get(i)-cost.get(i);

			if(tank < 0) {
				start = i+1;
				tank = 0;
			}
			remaining += gas.get(i)-cost.get(i);
		}
		return remaining >= 0 ? start : -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

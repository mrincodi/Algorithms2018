package pinos;

import java.util.List;

// https://www.interviewbit.com/problems/gas-station/
// This is the suboptimal, o(Nˆ2) solution.
// Check the O(n) one.
public class GasStationSuboptimal {

	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {


		outer:
			for ( int i = 0; i < A.size(); i++){
				int remains = 0;
				for ( int j = 0; j < A.size(); j++ ){
					int station = (i+j)% A.size();
					if ( remains + A.get (station) - B.get(station) < 0) continue outer;
					remains = remains + A.get (station) - B.get(station);
				}
				return i;
			}
	return -1;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

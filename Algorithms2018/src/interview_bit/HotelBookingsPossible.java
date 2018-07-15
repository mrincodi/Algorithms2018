package interview_bit;

import java.util.ArrayList;
import java.util.Collections;

// https://www.interviewbit.com/problems/hotel-bookings-possible/
// Easy.
public class HotelBookingsPossible {

	public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		int iArrive = 0, iDepart = 0;
		int occupancy = 0;

		Collections.sort ( arrive );
		Collections.sort ( depart );

		while ( iArrive < arrive.size() || iDepart < depart.size() ){
			// Compare current values.

			if ( iArrive < arrive.size() && iDepart < depart.size() ){
				int valArrive = arrive.get(iArrive );
				int valDepart = depart.get(iDepart );
				if ( valArrive < valDepart ){
					occupancy++;
					iArrive++;
				}
				else if ( valArrive > valDepart ){
					occupancy--;
					iDepart++;
				}
				else {
					iArrive++;
					iDepart++;
				}
			}
			else if ( iArrive == arrive.size() ){
				occupancy--;
				iDepart++;  
			}
			else { //iDepart == depart.size()
				occupancy++;
				iArrive++;
			}

			if ( occupancy > K ) return false;
		}

		return true;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

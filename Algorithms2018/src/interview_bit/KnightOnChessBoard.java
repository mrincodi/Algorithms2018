package interview_bit;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// https://www.interviewbit.com/problems/knight-on-chess-board/
// Still not working!!

public class KnightOnChessBoard {

	public int knight(int N, int M, int x1, int y1, int x2, int y2) {

		if ( x1 == x2 && y1 == y2 ) return 0;

		Queue < String > q = new LinkedList < String >();
		HashSet < String > already = new HashSet < String > ();

		q.add ( x1 + "_" + y1);
		q.add ( null );
		int moves = 0;
		while ( !q.isEmpty()){
			String thisPos = q.remove();

			if ( thisPos == null){
				if ( q.peek () == null ) return -1;

				q.add(null);
				moves++;
			}
			else {
				already.add ( thisPos );
				String [] posArray = thisPos.split ("_");

				int x = Integer.parseInt (posArray [ 0 ]);
				int y = Integer.parseInt (posArray [ 1 ]);

				if ( x == x2 && y == y2 ) return moves;

				// Find neighboring positions.

				addNeighbors ( N, M, x, y, already, q); // TODO
			}
		}

		return -1;

	}

	private void addNeighbors ( int N, int M, int x, int y, HashSet < String > already,  Queue < String > q){
		int x_1 = x - 2;
		int x_2 = x - 1;
		int x_4 = x + 1;
		int x_5 = x + 2;
		int y_1 = y - 2;
		int y_2 = y - 1;
		int y_4 = y + 1;
		int y_5 = y + 2;

		String s = "";

		s = x_1 + "_" + y_2;
		if ( x_1 >= 1 && y_2 >= 1 && !already.contains (s))
			q.add (s);

		s = x_2 + "_" + y_1;
		if ( x_2 >= 1 && y_1 >= 1 && !already.contains (s))
			q.add (s);                

		s = x_4 + "_" + y_1;
		if ( x_4 <= N && y_1 >= 1 && !already.contains (s))
			q.add (s);                

		s = x_5 + "_" + y_2;
		if ( x_5 <= N && y_2 >= 1 && !already.contains (s))
			q.add (x_1 + "_" + y_2);

		s = x_1 + "_" + y_4;
		if ( x_1 >= 1 && y_4 <= M && !already.contains (s))
			q.add (s);

		s = x_2 + "_" + y_5;
		if ( x_2 >= 1 && y_5 <= M && !already.contains (s))
			q.add (s);                

		s = x_4 + "_" + y_5;
		if ( x_4 <= N && y_5 <= M && !already.contains (s))
			q.add (s);                

		s = x_5 + "_" + y_4;
		if ( x_5 <= N && y_4 <= M && !already.contains (s))
			q.add (x_1 + "_" + y_2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package leetcode;

// https://leetcode.com/problems/battleships-in-a-board/description/
// Easy, honestly.
public class BattleshipsinABoard {

	public int countBattleships(char[][] board) {
		int result = 0;
		int height = board.length;
		int width = board[0].length;
		for ( int y = 0; y < width; y++ ){
			for ( int x = 0; x < height; x++ ){
				if ( board [x][y] == 'X'){
					if ( 
							( x == 0 && y == 0 ) ||
							( x > 0 && y > 0 && board [ x - 1][y] != 'X' && board [x][ y - 1] != 'X') ||
							( x == 0 &&  board [0][y - 1] != 'X') ||
							( y == 0 &&  board [x - 1][0] != 'X') )
						result ++;

				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

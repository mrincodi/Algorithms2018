package pinos;

import java.util.ArrayList;

//https://www.interviewbit.com/problems/nqueens/

public class NQueens {

	ArrayList<ArrayList<String>> solutions = new ArrayList<ArrayList<String>> ();
	public ArrayList<ArrayList<String>> solveNQueens(int a) {
		int [][] board = new int [a][a];
		solveNQueens (board, 0);
		return solutions;
	}

	void solveNQueens(int [][] board, int row ) {
		for ( int col = 0; col < board.length; col++){
			if (isValid (board, row, col)){
				board [row][col]=1;
				if ( row == board.length - 1 ){
					solutions.add(boardToArrayList(board));
				}
				else{
					solveNQueens (board, row + 1);
				}
				board [row][col]=0;
			}
		}
	}

	boolean isValid ( int [][] board, int row, int col){
		//Check if there is any queen above it.
		for ( int i = 0; i < row; i++)
			if (board[i][col]==1) return false;

		//Check if there is one on the left diagonal.
		boolean valid = true;
		int i = row - 1;
		int j = col - 1;
		while (valid){
			if ( i < 0 || j < 0) valid = false;
			else
				if ( board [i][j] == 1) return false;

			i--;
			j--;
		}

		valid = true;
		i = row - 1;
		j = col + 1;
		while (valid){
			if ( i < 0 || j == board.length) valid = false;
			else
				if ( board [i][j] == 1) return false;

			i--;
			j++;
		}

		return true;
	}


	ArrayList<String> boardToArrayList ( int [][] board ){
		ArrayList<String> result = new ArrayList<String> ();
		for ( int i = 0; i < board.length; i++){//rows
			StringBuffer rowB = new StringBuffer();
			for (int j = 0; j < board.length; j++){//#rows=#cols
				if ( board[i][j]==0)
					rowB.append(".");
				else
					rowB.append("Q");
			}
			result.add(rowB.toString());
		}
		return result;
	}





	public static void main(String[] args) {
		ArrayList<ArrayList<String>> solutions = new NQueens().solveNQueens(6);
		System.out.println (solutions);

	}

}

package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Spiral{

	public static void spiral ( int [] [] matrix ){
		int height = matrix.length;
		if ( height == 0) return;
		int width  = matrix [ 0 ].length;
		if ( width == 0 ) return;

		int limLeft = 0;
		int limRight = width-1;
		int limUp = 0;
		int limDown = height-1;

		int direction = 0;	// TODO: Do this with an enum
		int row = 0;
		int col = 0;

		while ( limLeft <= limRight && limUp <= limDown ){
			switch ( direction ){
				case 0:
					while ( col <= limRight )
						System.out.println (matrix [row][col++]);
					direction=1;
					limUp++;
					row++;
					col--;
				;;

				case 1:
					while ( row <= limDown )
						System.out.println (matrix [row++][col]);
					direction=2;
					limRight--;
					row--;
					col--;
				;;

				case 2:
					while ( col >= limLeft )
						System.out.println (matrix [row][col--]);
					direction=3;
					limDown--;
					col++;
					row--;
				;;

				case 3:
					while ( row >= limUp )
						System.out.println (matrix [row--][col]);
					direction=0;
					limLeft++;
					row++;
					col++;
				;;
			}
		}
		
	}
	
	
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> matrix) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
		int height = matrix.size();
		if ( height == 0) return result;
		int width  = matrix.get(0).size();
		if ( width == 0 ) return result;

		int limLeft = 0;
		int limRight = width-1;
		int limUp = 0;
		int limDown = height-1;

		int direction = 0;	// TODO: Do this with an enum
		int row = 0;
		int col = 0;

		while ( limLeft <= limRight && limUp <= limDown ){
			switch ( direction ){
				case 0:
					while ( col <= limRight )
						result.add((matrix.get(row).get(col++)));
					direction=1;
					limUp++;
					row++;
					col--;
					break;


				case 1:
					while ( row <= limDown )
						result.add((matrix.get(row++).get(col)));
					direction=2;
					limRight--;
					row--;
					col--;
					break;

				case 2:
					while ( col >= limLeft )
						result.add((matrix.get(row).get(col--)));
					direction=3;
					limDown--;
					col++;
					row--;
					break;

				case 3:
					while ( row >= limUp )
						result.add((matrix.get(row--).get(col)));
					direction=0;
					limLeft++;
					row++;
					col++;
					break;
				
				default:
					break;
			}
		}
		
    	return result;
    }
	
	
	public static void main ( String [] args) {
		System.out.println("qq");
		
		int [] [] matrix = {  { 1, 2, 3, 4},{ 5, 6, 7, 8 }, { 9, 10, 11, 12}, { 13,14,15,16 } };
		ArrayList <ArrayList<Integer>> mat = new ArrayList <ArrayList<Integer>>();
		mat.add((new ArrayList <Integer > ( Arrays.asList(1,2,3,4))));
		mat.add((new ArrayList <Integer > ( Arrays.asList(5,6,7,8))));
		mat.add((new ArrayList <Integer > ( Arrays.asList(9,10,11,12))));
		//mat.add((new ArrayList <Integer > ( Arrays.asList(13,14,15,16))));
		
		
		ArrayList < Integer> result = new Spiral().spiralOrder (mat);
		System.out.println  (result);
		
		
	}
}









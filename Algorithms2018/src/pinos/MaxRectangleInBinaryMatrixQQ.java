package pinos;

//import java.util.ArrayList;

//https://www.interviewbit.com/problems/max-rectangle-in-binary-matrix/
// A horrible attempt. Don't even look.

public class MaxRectangleInBinaryMatrixQQ {
//
//	    public int maximalRectangle(ArrayList<ArrayList<Integer>> A) {
//	        Pair[][] m = new Pair [A.size()][A.get(0).size()];
//
//	        int maxAreaSoFar = 0;
//	        int thisArea = 0;
//	        
//	        if ( A.get(0).get(0) == 0 ) {
//	            m[0][0] = new Pair (-1,-1);
//	        }
//	        else {
//	            m[0][0] = new Pair (0,0);
//	            thisArea = 1;
//	        }
//
//	        for (int i = 1; i < m.length; i++){
//	            if ( A.get(0).get(i) == 0 ){
//	                // I fill the matrix with -1, -1.
//	                m[0][i] = new Pair (-1, -1);
//	                //The current area is 0.
//	                thisArea = 0;
//	            }
//	            else { //The value is one in the original matrix.
//	                //What will I fill the matrix with? It depends.
//	                if (m[0][i-1].equals (-1,-1)){
//	                    //The previous was a 0 (or this is position 0,0).
//	                    m[0][i]=new Pair (0,i);
//	                    //The current area is 1.
//	                    thisArea = 1;
//	                }
//	                else {
//	                    m[0][i]=m[0][i-1];
//	                    thisArea++;
//	                }
//	            }
//	            maxAreaSoFar=Math.max(maxAreaSoFar,thisArea);
//	        }
//	            
//	            
//	        for (int i = 1; i < m[0].length; i++){
//	            if ( A.get(i).get(0) == 0 ){
//	                // I fill the matrix with -1, -1.
//	                m[i][0] = new Pair (-1, -1);
//	                //The current area is 0.
//	                thisArea = 0;
//	            }
//	            else { //The value is one in the original matrix.
//	                //What will I fill the matrix with? It depends.
//	                if (m[i-1][0].equals (-1,-1)){
//	                    //The previous was a 0 (or this is position 0,0).
//	                    m[i][0]=new Pair (i,0);
//	                    //The current area is 1.
//	                    thisArea = 1;
//	                }
//	                else {
//	                    m[i][0]=m[i-1][0];
//	                    thisArea++;
//	                }
//	            }
//	            maxAreaSoFar=Math.max(maxAreaSoFar,thisArea);
//	        }
//
//	        for ( int i = 1; i < m.length; i++ ){
//	            for ( int j = 1; j < m[0].length; j++ ){
//	                if (A.get(i).get(j)==0){
//	                    thisArea=0;
//	                    m[i][j]=new Pair (-1,-1);
//	                }
//	                else{
//	                    Pair upper = m[i - 1][j];
//	                    Pair left = m[i][j-1];
//	                    if (upper.equals(-1, -1) && left.equals (-1,-1)){
//	                        m[i][j]=new Pair (i,j);
//	                        thisArea = 1;
//	                    }
//	                    else if (upper.equals(-1,-1)){
//	                        //The larger rectangle is only this row
//	                        //starting where the last "0" was.
//	                        //Let's look for it the dumb way, 
//	                        //TODO: Enhance this.
//	                        int newCol = 0;
//	                        for ( int k = j - 1; k >=0; k--){
//	                            if (m[i][k].equals (-1,-1)){
//	                                newCol = k;
//	                                break;
//	                            }
//	                        }
//	                        m[i][j]=new Pair (i,k);
//	                    }
//	                    else if (left.equals(-1,-1)){
//	                        //The larger rectangle is only this row
//	                        //starting where the last "0" was.
//	                        //Let's look for it the dumb way, 
//	                        //TODO: Enhance this.
//	                        int newRow = 0;
//	                        for ( int k = i - 1; k >=0; k--){
//	                            if (m[k][j].equals (-1,-1)){
//	                                newRow = k;
//	                                break;
//	                            }
//	                        }
//	                        m[i][j]=new Pair (k,j);
//	                    }
//	                    else {
//	                        //Real business!
//	                        int newRow = Math.max (upper.x, left.x);
//	                        int newCol = Math.max (upper.y, left.y);
//	                        
//	                    }
//	                    
//	                }
//	            //Calculate the minimum square that "ends" in this position.
//	        }
//	        
//	    }
//
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
//	    
//	    class Pair{
//	        int x;
//	        int y;
//	        
//	        Pair (int x, int y){ this.x=x;this.y=y;}
//	        
//	        Pair (){ return Pair(-1,-1);}
//	            
//
//			boolean equals (Pair q) {
//	            return (this.x == q.x && this.y == q.y);
//	        }   
//	        
//	        boolean equals (int x, int y) {
//	            return (this.x == x && this.y == y);
//	        }
//	    }

}

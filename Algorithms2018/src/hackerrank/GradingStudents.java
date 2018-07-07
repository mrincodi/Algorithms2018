package hackerrank;

// https://www.hackerrank.com/challenges/grading/problem
// Veeeeery simple... But can be done interestingly in a single line!

public class GradingStudents {

	   static int[] gradingStudents(int[] grades) {
	        int [] result = new int [ grades.length ];
	        for ( int i = 0; i < grades.length; i++ ){
	            int n = grades [ i ];
//	            int r = n;
//	            
//	            if ( n >= 38 ){            
//	                if (n % 5 ==  3 ){
//	                    r = n + 2;
//	                }
//	                else if (n % 5 ==  4 ){
//	                    r = n + 1;
//	                }
//	            }
//	            
	            int r = n >= 38 ? n % 5 == 3 ? n + 2 : n % 5 == 4 ? n + 1 : n : n; // Sexy.
	            result [ i ] = r; 
	        }
	        return result;

	    }
	public static void main(String[] args) {



        
	}

	
}

package hackerrank;

// https://www.hackerrank.com/challenges/time-conversion/problem
// An actual interesting yet simple problem of conversion from
// 12-h to 24h format.
public class TimeConversion {

    static String timeConversion(String s) {
        
        String result = "";
        String AMOrPM = s.substring (8);
        
        if ( AMOrPM.equals ("AM")){
            if (s.substring (0,2).equals ( "12" ) ){
                result = "00" + s.substring (2,8);
            }
                
            else {
                result = s.substring(0,8);
            }
        }
        else {
            if ( s.substring (0,2).equals ( "12" ) ){
                result = s.substring(0,8);
            }
            else {
                int hours = Integer.parseInt (s.substring (0,2));
                hours += 12;
                result = hours + s.substring (2,8);
            }
        }
        
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

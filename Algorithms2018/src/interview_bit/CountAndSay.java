package interview_bit;

//https://www.interviewbit.com/problems/count-and-say/

public class CountAndSay {

    public String countAndSay(int A) {
        String result = "1";
        
        if ( A == 1) return result;
        for ( int i = 2; i <=A; i++){
        	System.out.println(i + ":" + result);
            String prevResult = new String (result);
            char prevChar = prevResult.charAt(0);
            result = "";
            int numTimes = 1;
            for ( int j = 1; j < prevResult.length(); j++ ){
                char c = prevResult.charAt(j);
                if ( c == prevChar ){
                    numTimes++;
                }
                else {
                    result = result + numTimes + prevChar + "";
                    numTimes = 1;
                    prevChar = c;
                }
            }
            result = result + numTimes + prevChar + "";
        }
        return result;
    }
    
	public static void main(String[] args) {
		System.out.println( new CountAndSay().countAndSay(40));

	}

}

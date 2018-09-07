package interview_bit;

// https://www.interviewbit.com/problems/reverse-the-string/
// Back to the basics.
// 2018-08-17
// 15m.
public class ReverseTheString {

    // "the sky is blue" -> "blue is sky the".
    // "    the sky     is    blue    " -> "blue is sky the".
    // "    the      sky     is    blue    " -> "blue is sky the        ".
    // Tabs, etc. are valid letters. All except whitespace is part of a word.
    public String reverseWords(String a) {
        
        String result = ""; // TODO: Enhance later w/ StringBuffer.
        String word = "";  // TODO: ...
        
        a = a + " ";
        boolean wordStarted = false;
        
        for ( int i = 0; i < a.length (); i++ ){
            char c = a.charAt ( i );
            
            if ( c != ' '){
                wordStarted = true;
                word = word + c;
            }
            else { // if whitespace
                if ( wordStarted ) {
                    wordStarted = false;
                    result = word + " " + result;
                    word = "";
                }
            }
        }
        
        if ( result.length () > 0 )
            return result.substring (0,result.length() - 1);
        else
            return "";
        
    }
}


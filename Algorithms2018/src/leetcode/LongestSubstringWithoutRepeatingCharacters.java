package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
//In O(n). Could be made faster with a HashMap.
// Compare the sliding window answer below.

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {

		if ( s.length () <= 1) return s.length(); 
		HashSet <Character> letters = new HashSet <Character> ();
		int start = 0;
		int end = 1;
		String result = "";
		letters.add(s.charAt (0));

		while ( end < s.length ()){
			char c = s.charAt (end);

			if ( !letters.contains (c)){
				letters.add(c);
				end++;
			}
			else {
				//Get current word.
				String word = s.substring (start, end);
				if ( word.length () > result.length () ){
					result = word;
				}

				//Fix current set.
				// Just look for the previous appearance of the character.
				char startC = s.charAt (start);

				while ( startC != c ){
					startC = s.charAt (start);
					if ( startC == c ){
						break;
					}
					else {
						letters.remove(startC); 
						start++;
					}
				}
				start++;
				end++;
			}
		}

		//Consider last word.
		String word = s.substring (start, end);
		if ( word.length () > result.length () ){
			result = word;
		}

		return result.length();

	}

	public int lengthOfLongestSubstringLeetCode(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		int ans = 0, i = 0, j = 0;
		while (i < n && j < n) {
			// try to extend the range [i, j]
			if (!set.contains(s.charAt(j))){
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			}
			else {
				set.remove(s.charAt(i++));
			}
		}
		return ans;
	}

	public int lengthOfLongestSubstringLeetCode2(String s) {
		int n = s.length(), ans = 0;
		Map<Character, Integer> map = new HashMap<>(); // current index of character
		// try to extend the range [i, j]
		for (int j = 0, i = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

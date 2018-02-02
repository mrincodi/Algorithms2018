package pinos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Palin {
	public Set<String> findPalindromes(String s) {
		int len = s.length();
		// The map below will contain all palindromes sequences and the latest location of
		Map<String, Integer> wordLocMap = new HashMap<String, Integer>();
		// The map below will contain all characters scanned and their locations
		Map<Character, List<Integer>> charLocMap = new HashMap<Character, List<Integer>>();
		// scan the chracters from left to right
		for (int i = 0; i < len; i++) {
			Character currChar = s.charAt(i);
			String single = s.substring(i, i+1);
			List<Integer> charLocList = charLocMap.get(currChar);
			if (charLocList == null) {
				// The first time this character was met
				charLocList = new ArrayList<Integer>();
				charLocMap.put(currChar, charLocList);
			} else {
				// The same character was met earlier
				// The map below will contain all the new palindromes with this new character
				Map<String, Integer> newWordLocMap = new HashMap<String, Integer>();
				for (Map.Entry<String, Integer> entry : wordLocMap.entrySet()) {
					String oldPalindrome = entry.getKey();
					// The location of the head of this palindrome
					Integer headLoc = entry.getValue();
					// a new palindrome is possilbe if the head of the existing palindrome
					// is behind the first location of this character
					if (headLoc > charLocList.get(0)) {
						// this is a new palindrome
						String newPalindrome = single + oldPalindrome + single;
						// find out the latest location of head of this new palindrome
						// It is the biggest possible location that is smaller than headLoc
						// Binary search can be used because the location is always added from
						// small to big to the list
						newWordLocMap.put(newPalindrome, findLoc(charLocList, headLoc));
					}
				}
				// adding all new palindromes
				wordLocMap.putAll(newWordLocMap);
				// update the word location of the palindromes that has the same characters
				String sameCharString = single;
				for (int j = charLocList.size() - 1;j >= 0; j--)
				{
					sameCharString = sameCharString + single;
					wordLocMap.put(sameCharString, charLocList.get(j));
				}
			}
			// This new character is a palindrome itself
			wordLocMap.put(single, new Integer(i));
			// add a new location of this character
			charLocList.add(new Integer(i));
		}
		// The map contains all palindrome sequences
		return wordLocMap.keySet();
	}
	// Method using binary search to find the biggest location that is smaller than loc
	private Integer findLoc(List<Integer> charLocList, Integer loc) {
		int low = 0;
		int hi = charLocList.size() - 1;
		while (low <= hi) {
			int mid = low + (hi - low)/
					2;
			if (loc <= charLocList.get(mid)) {
				hi = mid-1;
			} else {
				low = mid+1;
			}
		}
		return (hi < 0) ? charLocList.get(0) : charLocList.get(hi);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

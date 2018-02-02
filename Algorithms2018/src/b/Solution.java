package b;

import java.io.*;
import java.util.*;


// We have some clickstream data that we gathered on our client's website. Using cookies, we collected snippets of users' anonymized URL histories while they browsed the site. The histories are in chronological order and no URL was visited more than once per person.

// Write a function that takes two user’s browsing histories as input and returns the longest contiguous sequence of URLs that appears in both.

// Sample input:

// user0 = [ "/nine.html", "/four.html", "/six.html", "/seven.html", "/one.html" ]
// user1 = [ "/one.html", "/two.html", "/three.html", "/four.html", "/six.html" ]
// user2 = [ "/nine.html", "/two.html", "/three.html", "/four.html", "/six.html",
//	           "/seven.html" ]
// user3 = [ "/three.html", "/eight.html" ]

// Sample output:

// (user0, user2):
//	    /four.html
//	    /six.html
//	    /seven.html

// (user1, user2):
//	    /two.html
//	    /three.html
//	    /four.html
//	    /six.html

// (user0, user3):
//	    None

// (user1, user3):
//	    /three.html


class Solution {
	public static void main(String[] args) {
		List<String> user0 = Arrays.asList(
				"/nine.html", "/four.html", "/six.html", "/seven.html", "/one.html" );
		List<String> user1 = Arrays.asList(
				"/one.html", "/two.html", "/three.html", "/four.html", "/six.html");
		List<String> user2 = Arrays.asList(
				"/nine.html", "/two.html", "/three.html", "/four.html", "/six.html",
				"/seven.html");
		List<String> user3 = Arrays.asList("/three.html", "/eight.html");

		List <String> contiguousSeq = new Solution().contiguous (user0, user2);

		System.out.println(contiguousSeq);
	}

	List <String> contiguous (List<String> seq1, List<String> seq2){

		ArrayList <String> result = new ArrayList <String> ();

		if ( seq1.size() == 0 || seq2.size() == 0) return result;

		HashMap <String, Integer> positions = new HashMap <String, Integer>();

		for ( int i = 0; i < seq1.size(); i++)
			positions.put (seq1.get(i), i);      

		for ( int i = 0; i < seq2.size(); i++){
			
			String checkedString = seq2.get(i);
			
			if (positions.containsKey(checkedString)){
				ArrayList<String> thisSeq = new ArrayList<String>();
				checkedString = seq2.get(i);
				thisSeq.add (checkedString);
				int indexA = positions.get(checkedString)+1;
				int indexB = i + 1;
				
				while ( indexA < seq1.size() && indexB < seq2.size()){
					if (seq1.get(indexA) == seq2.get(indexB)){
						thisSeq.add (seq1.get(indexA));
						indexA++;
						indexB++;
					}
					else
						break;
				}

				if ( thisSeq.size()> result.size()) result = thisSeq;
				i = indexB-1;


			}
		}

		return result;
	}


}

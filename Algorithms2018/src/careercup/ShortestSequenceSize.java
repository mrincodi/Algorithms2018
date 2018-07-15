package careercup;

import java.util.HashSet;
import java.util.Set;

// https://www.careercup.com/question?id=5745302387556352
// OMG, this is the silliest answer ever. Good brain teaser!
// GREEDY!
// 2018-07-12
public class ShortestSequenceSize {

	public  int  shortestNonSeq(int[]  a,  int k){
		int result   = 0 ;
		Set<Integer>   flag =  new  HashSet < Integer > ();
		for (int i  = 0; i   < a.length; i++)  {
			if  (!flag.contains(a[i]))  {
				flag.add(a[i]);
				if (flag.size() == k) {
					result++;
					flag = new HashSet<>();
				}
			}
		}
		return result + 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

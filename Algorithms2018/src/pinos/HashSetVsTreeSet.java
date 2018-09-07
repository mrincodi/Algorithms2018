package pinos;

public class HashSetVsTreeSet {
	public static void main(String[] args) {
		java.util.HashSet <Integer> hashSet = new java.util.HashSet <> ();
		java.util.TreeSet <Integer> treeSet = new java.util.TreeSet <> ();
		
		for ( int i = 3; i >= -3; i = i - 1 ){
			hashSet.add(i);
			treeSet.add(i);
		}
		
		java.util.Iterator <Integer> hashSetIter = hashSet.iterator();
		java.util.Iterator <Integer> treeSetIter = treeSet.iterator();
		
		System.out.print ("HashSet elements: ");
		while (hashSetIter.hasNext()){
			System.out.print(hashSetIter.next() + " ");
		}
		
		System.out.print ("\nTreeSet elements: ");
		while (treeSetIter.hasNext()){
			System.out.print(treeSetIter.next() + " ");
		}
	}
}

package pinos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeMap;

public class VerticalOrderTraversalOfABinaryTree {

	/**
	 * Definition for binary tree
	 * class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) {
	 *      val = x;
	 *      left=null;
	 *      right=null;
	 *     }
	 * }
	 */


	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
			left=null;
			right=null;
		}
	}
	class Pair {
		int columnNumber;
		TreeNode node;

		Pair (int columnNumber, TreeNode node) {
			this.columnNumber=columnNumber;
			this.node=node;
		}
	}

	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (A == null) return result;

		TreeMap <Integer, ArrayList <Integer>>columns = new TreeMap <Integer, ArrayList <Integer>> ();
		generateTreeMap (A, columns);

		Iterator <Integer> iterator = columns.keySet().iterator();

		while (iterator.hasNext()){
			result.add (columns.get(iterator.next()));
		}
		return result;
	}

	void generateTreeMap (TreeNode A, TreeMap <Integer, ArrayList <Integer>> columns){

		ArrayList <Pair > queue = new ArrayList <Pair >();

		Pair p = new Pair (0,A);

		queue.add (p);

		while (!queue.isEmpty()){
			Pair thisPair = queue.get(0);

			if (!columns.containsKey (thisPair.columnNumber))
				columns.put(thisPair.columnNumber,new ArrayList<Integer>(Arrays.asList(thisPair.node.val)));    
			else
				columns.get(thisPair.columnNumber).add(thisPair.node.val);

			if ( thisPair.node.left != null){
				queue.add (new Pair ( thisPair.columnNumber - 1, thisPair.node.left));
			}
			if ( thisPair.node.right != null){
				queue.add (new Pair ( thisPair.columnNumber + 1, thisPair.node.right));
			}

			queue.remove (0);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

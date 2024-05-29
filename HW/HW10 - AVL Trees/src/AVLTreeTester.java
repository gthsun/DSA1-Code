
import tree.AVLTree;
import tree.BinarySearchTree;

import java.util.ArrayList;

public class AVLTreeTester {

	public static void main(String[] args) {
		
		/* Here are two test cases for your implementations. */
		/* You SHOULD create more */
		
		/*
		 * 	Correct output:		  	
		 *	AVL Pre: 4 2 1 3 8 6 5 7 9 
		 *	AVL In: 1 2 3 4 5 6 7 8 9 
		 *	AVL Post: 1 3 2 5 7 6 9 8 4 
		 */
		AVLTree<Integer> avl = new AVLTree<Integer>();
		
		
		int[] toInsert = {5,4,3,2,1,9,8,7,6};
/*
		ArrayList<Integer> toInsert = new ArrayList<Integer>();

		for(int i = 0; i < 5000; i++){
			toInsert.add(i);
		}
		for(int i = 10000; i > 5000; i--){
			toInsert.add(i);
		}*/
		
		for(int i : toInsert) {
			avl.insert(i);
			//System.out.println("Success with "+ i);
		}
		
		/* Print out pre, in, and post-order */		
		System.out.print("AVL Pre: " + avl.getPreOrder());
		System.out.print("AVL In: " + avl.getInOrder());
		System.out.print("AVL Post: " + avl.getPostOrder());
		
	}
}

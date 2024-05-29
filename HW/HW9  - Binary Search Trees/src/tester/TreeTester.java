package tester;
import tree.BinarySearchTree;

import java.util.ArrayList;

public class TreeTester {
    public static void main(String[] args) {

        /* Here are two test cases for your implementations. */
        /* You SHOULD create more */

        /*
         * 	Correct output:
         * 	BST Pre: 5 4 3 2 1 9 8 7 6
         *	BST In: 1 2 3 4 5 6 7 8 9
         *	BST Post: 1 2 3 4 6 7 8 9 5
         *	AVL Pre: 4 2 1 3 8 6 5 7 9
         *	AVL In: 1 2 3 4 5 6 7 8 9
         *	AVL Post: 1 3 2 5 7 6 9 8 4
         */

        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();


        int[] toInsert = {5,4,3,2,1,9,8,7,6};
        //ArrayList<Integer> toInsert = new ArrayList<Integer>();
        //int[] toInsert = {5,7,3,10,6,2,4,1,9,8};
        //int[] toInsert = {1,2,3,4,5,6,7,8,9};

        for(int i : toInsert) {
            bst.insert(i);
        }
        for(int i : toInsert) {
            bst2.insert(i);
        }

        System.out.println("EQUAL??: " + bst.equals(bst2));

        /* Print out pre, in, and post-order */
        System.out.println("BST Pre: " + bst.getPreOrder());
        System.out.println("BST In: " + bst.getInOrder());
        System.out.println("BST Post: " + bst.getPostOrder());

        System.out.println("Height of BST is " + bst.height());

        for(int i : toInsert) {
            bst.remove(i);
            System.out.println("BST after removing " + i + ":  " + bst.getInOrder());
        }


    }
}


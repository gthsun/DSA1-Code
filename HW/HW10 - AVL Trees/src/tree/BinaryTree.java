//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//Homework: HW 10 - AVL Trees
//Resources Used: None

package tree;

//A class that contains a Binary search tree that can be traversed through in order, pre ordered, and post ordered
public class BinaryTree<T> {

	//Field that sets the root node to null (or empty)
	protected TreeNode<T> root = null;

	/* Tree Traversal methods */

	//HINT for three traversal methods: you can call toString() on the node's
	//     data when you are executing the "root" command on a given node
	//     (e.g. curNode.data.toString() + " ";) // Note the space added at the end

	public String getInOrder() {return getInOrder(root);} // call getInOrder starting at the root!

	//Traverses the tree by traversing to the left of the node, visiting the node, and traversing to the right of the node
	private String getInOrder(TreeNode<T> curNode) {
		//TODO: return the in order traversal of this tree, space separated
		String result = "";
		if(curNode != null) {
			if (curNode.left == null && curNode.right == null) {
				result = curNode.data.toString()+" ";
			} else if (curNode.left != null && curNode.right == null) {
				result = getInOrder(curNode.left)+curNode.data.toString()+" ";
			} else if (curNode.left == null && curNode.right != null) {
				result = curNode.data.toString()+" "+getInOrder(curNode.right);
			} else {
				result = getInOrder(curNode.left)+curNode.data.toString()+" "+getInOrder(curNode.right);
			}
		}
		return result;
	}

	public String getPreOrder() {
		return getPreOrder(root); // call getPreOrder starting at the root!
	}

	//Traverses the tree by visiting the node, traversing to the left of the node, and traversing to the right of the node
	private String getPreOrder(TreeNode<T> curNode) {
		String result = "";
		if(curNode != null) {
			if (curNode.left == null && curNode.right == null) {
				result = curNode.data.toString()+" ";
			} else if (curNode.left != null && curNode.right == null) {
				result = curNode.data.toString()+" "+getPreOrder(curNode.left);
			} else if (curNode.left == null && curNode.right != null) {
				result = curNode.data.toString()+" "+getPreOrder(curNode.right);
			} else {
				result = curNode.data.toString()+" "+getPreOrder(curNode.left)+getPreOrder(curNode.right);
			}
		}
		return result;
	}


	public String getPostOrder() {
		return getPostOrder(root);  // call getPostOrder starting at the root!
	}

	//Traverses the tree by traversing to the left of the node, traversing to the right of the node, then visiting the node
	private String getPostOrder(TreeNode<T> curNode) {
		//TODO: return the post order traversal of this tree, space separated
		String result = "";
		if(curNode != null) {
			if (curNode.left == null && curNode.right == null) {
				result = curNode.data.toString()+" ";
			} else if (curNode.left != null && curNode.right == null) {
				result = getPostOrder(curNode.left)+curNode.data.toString()+" ";
			} else if (curNode.left == null && curNode.right != null) {
				result = getPostOrder(curNode.right)+curNode.data.toString()+" ";
			} else {
				result = getPostOrder(curNode.left)+getPostOrder(curNode.right)+curNode.data.toString()+" ";
			}
		}
		return result;
	}


	//------------------------------------------------------------------------
	//EVERYTHING BELOW THIS POINT IS IMPLEMENTED FOR YOU
	//YOU SHOULD STILL LOOK AT THIS CODE
	//------------------------------------------------------------------------

	/* A somewhat more pretty print method for debugging */
	public void printTree() {
		printTree(this.root, 0);
		System.out.println("\n\n");
	}
	private void printTree(TreeNode<T> curNode, int indentLev) {
		if(curNode == null) return;
		for(int i=0; i<indentLev; i++) {
			if(i == indentLev - 1) System.out.print("|-----");
			else System.out.print("      ");
		}
		System.out.println(curNode.data);
		printTree(curNode.left, indentLev+1);
		printTree(curNode.right, indentLev+1);
	}

	//TODO: Look at these methods and think about how they might be useful for this assignment
	public int height() {
		return height(root);
	}

	/* Computes the height of the tree on the fly */
	protected int height(TreeNode<T> node) {
		if(node == null) return -1;
		return 1 + Math.max(height(node.left), height(node.right));
	}
}

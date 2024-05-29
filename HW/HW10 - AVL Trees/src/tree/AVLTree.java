//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//Homework: HW 10 - AVL Trees
//Resources Used: None

package tree;

/**
 * Self-balancing AVL Tree
 * @author CS 2100 Team
 *
 * @param <T>
 */
 
public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T>{
	
	@Override
	public void insert(T data) {
		//Calls insert starting at the root of the tree
		this.root = insert(data, this.root);
	}

	//Inserts a new node and balances the tree accordingly
	protected TreeNode<T> insert(T data, TreeNode<T> curNode) {
		//Calls BinarySearchTree's insert method
		//Uses super call - more efficient
		curNode = super.insert(data, curNode);

		if(curNode == null) return null; //Null check

		//Updates heights if necessary (no change is fine)
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;

		//Balances the tree (rotates if necessary)
		curNode = this.balance(curNode);

		return curNode;
	}
	
	@Override
	public void remove(T data) {
		/* Call remove starting at the root of the tree */
		this.root = remove(data, this.root);
	}
	protected TreeNode<T> remove(T data, TreeNode<T> curNode) {
		/* Call BST remove before balancing, use “super” to achieve this */
		curNode = super.remove(data,  curNode);
		
		/* Handle the case when remove returns null */
		if(curNode == null) return null;
		
		/* update the height of this node if necessary (if no change, that’s OK) */
		curNode.height = Math.max(height(curNode.left), height(curNode.right))+1;
		
		/* rotate if necessary (call balance() method to balance the node) */
		curNode = this.balance(curNode);
		
		return curNode;
	}

	
	/**
	 * Balances the given node. Assumes it is the lowest unbalanced node if unbalanced
	 * @param curNode
	 * @return
	 */
	private TreeNode<T> balance(TreeNode<T> curNode) {
		//Balance factor saved to an integer
		int bF = balanceFactor(curNode);
		if(bF > 1){ //left heavy
			//If left rotation is necessary before rotating right
			if (balanceFactor(curNode.left) < 0) {
				curNode.left = rotateLeft(curNode.left); //rotate bottom two left
			}
			curNode = rotateRight(curNode); //rotate right ("pick up" middle node)

		} else if(bF < -1){ //right heavy
			//If right rotation is necessary before rotating left
			if (balanceFactor(curNode.right) > 0) {
				curNode.right = rotateRight(curNode.right); // rotate bottom two right
			}
			curNode = rotateLeft(curNode); //rotate left ("pick up" middle node)
		}
		return curNode;
	}
	
	private TreeNode<T> rotateRight(TreeNode<T> curNode) {
		TreeNode<T> root = curNode.left; //Left node of current root is set as new "root" node
		curNode.left = root.right; //Left of current root should be new root's current right node
		root.right = curNode; //Set new root's NEW right node to be current root

		return root;
	}
	
	private TreeNode<T> rotateLeft(TreeNode<T> curNode){
		TreeNode<T> root = curNode.right; //Right node of current root is set as new "root" node
		curNode.right = root.left; //Right of current root should be new root's current left node
		root.left = curNode; //Set new root's NEW left node to be current root

		return root;
	}

	//Calculates balance factor at a root node = left height - right height
	private int balanceFactor(TreeNode<T> node) {
		return height(node.left) - height(node.right);
	}
	
	
}

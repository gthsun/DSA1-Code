//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//HW7 - LinkedLists
//Resources Used: None

package list;

/**
 * A tool used to iterate through a LinkedList given a node within the list
 */
public class ListIterator<T> { 
	protected ListNode<T> curNode;  /* Current node (of type ListNode<T>) */
	
	/* ListIterator constructor. Accepts the current node. */
	public ListIterator(ListNode<T> currentNode) {
		curNode = currentNode;
	}
	
	/**
	 * These two methods tell us if the iterator has run off
	 * the list on either side
	 */
	public boolean isPastEnd() {
		//If next is null, node is tail
		if(curNode.next == null) return true;
		return false;

	}
	
	public boolean isPastBeginning() {
		//If prev is null, node is head
		if(curNode.prev == null) return true;
		return false;
	}
	
	/**
	 * Get the data at the current iterator position
	 * Return the data if appropriate, otherwise return null
	 */
	public T value() {
		if(curNode != null)
			return curNode.getData();
		return null;
	}
	
	/**
	 * These two methods move the cursor of the iterator
	 * forward / backward one position
	 */
	public void moveForward() {
		//Checks if at tail node first
		if(!isPastEnd()) curNode = curNode.next;
	}
	
	public void moveBackward() {
		//Checks if at head node first
		if(!isPastBeginning()) curNode = curNode.prev;
	}
}



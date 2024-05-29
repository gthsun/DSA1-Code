package sclist;

/**
 * 
 * A custom built singly-linked circular list
 * T here is the type the list stores
 */
public class SCLinkedList<T> implements SimpleList<T>{

	private ListNode<T> head;
	private int size;
	
	public SCLinkedList() { // constructor
		head = null;
		size = 0;
	}
	
	public int size() {
		return this.size;
	}
	
	/**
	 * Clears out the entire list
	 */
	public void clear() {
		head = null;
		size = 0;
	}
	
	/**
	 * Inserts new data at the end of the list (i.e., just before where head is pointing)
	 * @param data
	 */
	public void insertAtTail(T data) {
		//TODO: Finish implementing this method
		if (head == null) { // inserting first node in the list
			ListNode<T> insertNode = new ListNode<T>(data, null); // node to insert
			insertNode.next = insertNode;
			head = insertNode;
		}
		else if (size == 1) {  // if list only has one node
			ListNode<T> insertNode = new ListNode<T>(data, head); // node to insert
			head.next = insertNode;
		}
		else {  // general case
			// allocate node and point node to list
			ListNode<T> insertNode = new ListNode<T>(data, head); // node to insert
			// find last node in list that points to head
			ListNode<T> temp = head;
			while (temp.next != head)
				temp = temp.next;
			temp.next = insertNode;
		}
		size++;
	}
	
	/**
	 * Inserts data at the front of the list (i.e., in front of where head is pointing
	 * @param data
	 */
	public void insertAtHead(T data) {
		//TODO: Finish implementing this method
		if (head == null) { // first node in the list
			ListNode<T> insertNode = new ListNode<T>(data, null); // node to insert

			insertNode.next = insertNode;
			head = insertNode;
		}
		else if (size == 1){  // there is only one node in the list
			ListNode<T> insertNode = new ListNode<T>(data, head); // node to insert
			head.next = insertNode;
			head = insertNode;
		}
		else { // general case
			ListNode<T> insertNode = new ListNode<T>(data, head); // node to insert
			// find last node in list that points to head
			ListNode<T> temp = head;
			while (temp.next != head)
				temp = temp.next;
			temp.next = insertNode;
			head = insertNode;
		}
		size++;
	}

	public T removeAtTail() {  // remove node immediately before head
		//TODO: Finish implementing this method
		T value = null;  // value to be returned
		if (size == 0) // if empty
			return null;
		else if (size == 1) {  // removing last node in list
			value = head.getData();
			head = null;//TODO: if we just removed the last node, then what should head point to?
		}
		else { // general case
			// move to next to last node in list
			ListNode<T> temp = head;
			for (int i = 0; i < size-2; i++)    // loop size-2 times
				temp = temp.next;
			value = temp.next.getData(); //TODO: return the appropriate data
			temp.next = head;//TODO: remove node from list
		}
		size--; // shorten size
		return value;
	}
	
	public T removeAtHead(){
		//TODO: Finish implementing this method
		T value = null;
		if (size == 0)
			return null;
		else if (size == 1) {  // removing last node in list
			value = head.getData();
			head = null;//TODO: if we just removed the last node, then what should head point to?
		}
		else { // general case
			value = head.getData();
			// find the node in list that points to head to change where it points
			ListNode<T> temp = head;
			while (temp.next != head)
				temp = temp.next;
			temp.next = head.next;//TODO: remove node from list
			head = head.next;//TODO: where does head point now?
		}
		size--; // decrease size
		return value;
	}

	/**
	 * Returns index of first occurrence of the data in the list, or -1 if not present
	 * @param data
	 * @return
	 */
	public int find(T data) {
		ListNode<T> curNode = head;
		int index = 0;
		if (head.getData().equals(data))
			return index;
		else
			curNode = curNode.next;
		index++;
		while (curNode != head) {
			if (curNode.getData().equals(data)) {
				return index;
			}
			curNode = curNode.next;
			index++;
		}
		return -1;
	}

	/**
	 * Returns the list as space separated values
	 */
	public String toString() {
		String toRet = "[";

		ListNode<T> curNode = head;
		for (int i = 0; i < size; i++) {   // loop size times
			toRet += curNode.getData() + " ";
			curNode = curNode.next;
		}

		return toRet + "]";
	}

}

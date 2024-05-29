//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//HW7 - LinkedLists
//Resources Used: None

package list;

import java.util.List;

/**
 * 
 * A custom built linked list
 * Uses reference nodes rather than arrays to contain the elements together
 * T here is the type the list stores
 */
public class LinkedList<T> implements SimpleList<T>{

	/* Dummy head and tail */
	private ListNode<T> head, tail;

	/*The number of elements in the LinkedList*/
	private int size;

	/**Default constructor that initializes a LinkedList*/
	public LinkedList() {
		head = new ListNode<T>(null);
		tail = new ListNode<T>(null);
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**Returns the number of elements in the LinkedList*/
	public int size() {
		return size;
	}

	/**
	 * Clears out the entire list
	 * head's next node is set to tail, and tail's prev node is set to head
	 */
	public void clear() {
		head.next = tail;
		tail.prev = head;
		size = 0;
	}

	/**
	 * Inserts new data at the end of the list (i.e., just before the dummy tail node)
	 * @param data
	 */
	public void insertAtTail(T data) {
		ListNode<T> node = new ListNode<T>(data);
		node.prev = tail.prev;
		node.next = tail;
		tail.prev.next = node;
		tail.prev = node;
		size++;
	}

	/**
	 * Inserts data at the front of the list (i.e., just after the dummy head node)
	 * @param data
	 */
	public void insertAtHead(T data) {
		ListNode<T> node = new ListNode<T>(data);
		node.next = head.next;
		node.prev = head;
		head.next.prev = node;
		head.next = node;
		size++;
	}

	/**
	 * Inserts node such that index becomes the position of the newly inserted data
	 * @param data
	 * @param index
	 */
	public void insertAt(int index, T data) {
		ListIterator<T> it = new ListIterator<T>(head);
		if(index <= size){
			for(int i = 0; i <= index; i++){
				it.moveForward();
			}
			ListNode<T> node = new ListNode<T>(data);
			node.next = it.curNode;
			node.prev = it.curNode.prev;
			it.curNode.prev.next = node;
			it.curNode.prev = node;
			size++;
		}
	}

	/**
	 * Inserts data after the node pointed to by iterator
	 */
	public void insert(ListIterator<T> it, T data) {
		ListNode<T> node = new ListNode<T>(data);
		node.prev = it.curNode;
		node.next = it.curNode.next;
		it.curNode.next.prev = node;
		it.curNode.next = node;
		size++;
	}

	/**
	 * Removes the node right before the tail, or the last node in the list
	 */
	public T removeAtTail(){
		if(size > 0){
			ListNode<T> node = tail.prev;
			node.prev.next = tail;
			tail.prev = node.prev;
			size--;
			return node.getData();
		}
		return null;

	}

	/**
	 * Removes the node right after the head, or the first node in the list
	 */
	public T removeAtHead(){
		if(size > 0){
			ListNode<T> node = head.next;
			node.next.prev = head;
			head.next = node.next;
			size--;
			return node.getData();
		}
		return null;

	}

	/**
	 * Remove based on Iterator position
	 * Sets the iterator to the node AFTER the one removed
	 */
	public T remove(ListIterator<T> it) {
		if(size > 0){
			ListNode<T> node = it.curNode;
			T data = node.getData();
			ListNode<T> prevNode = node.prev;
			prevNode.next = node.next;
			it.moveForward();
			it.curNode.prev = prevNode;
			size--;
			return data;
		}
		return null;

	}

	/**
	 * Returns index of first occurrence of the data in the list, or -1 if not present
	 * @param data
	 * @return
	 */
	public int find(T data) {
		ListIterator<T> it = new ListIterator<T>(head);
		int cnt = 0;
		while(it.curNode != tail){
			it.moveForward();
			if(it.curNode != tail) if(it.value().equals(data)) return cnt;
			cnt++;
		}
		return -1;
	}

	/**
	 * Returns the data at the given index, null if anything goes wrong (index out of bounds, empty list, etc.)
	 * @param index
	 * @return
	 */
	public T get(int index) {
		//Checks if anything went wrong
		if(index > size || size == 0){
			return null;
		}
		ListIterator<T> it = new ListIterator<T>(head);
		for(int i = 0; i <= index; i++){
			it.moveForward();
		}
		return it.curNode.getData();
	}

	/**
	 * Returns a string of the the list as space separated values
	 */
	public String toString() {
		String toRet = "[";

		ListNode<T> curNode = head.next;
		while(curNode != tail) {
			toRet += curNode.getData() + ", ";
			curNode = curNode.next;
		}

		return toRet + "]";
	}

	/* Return iterators at front and end of list */
	public ListIterator<T> front(){
		return new ListIterator<>(head.next);
	}

	public ListIterator<T> back() {
		return new ListIterator<>(tail.prev);
	}
	
}

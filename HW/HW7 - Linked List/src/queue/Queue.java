//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//HW7 - LinkedLists
//Resources Used: None

package queue;

import list.LinkedList;

/**
 * A Linked-List based Queue
 * LIFO (Last In, First Out):
 * New terms added to the "end" unless specified, old terms removed from the "front" unless specified
 * @param <T>
 */
public class Queue<T> implements IQueue<T>{
	private LinkedList<T> list;
	/**
	 * Constructor: Initialize the inner list
	 */
	public Queue(){
		list = new LinkedList<T>();
	}

	/**
	 * Return the size by invoking the size of the list
	 */
	public int size() {
		return list.size();
	}

	/**
	 * Simply add the data to the tail of the linked list
	 */
	public void enqueue(T data) {
		list.insertAtTail(data);
	}

	/**
	 * Simply remove data from the head of the list, throw exception if list is empty.
	 */
	public T dequeue() throws EmptyQueueException {
		if(list.size() == 0){
			//Throws an Exception if the Queue is empty (has no elements)
			throw new EmptyQueueException("Queue is empty");
		}
		return list.removeAtHead();
	}

	/**
	 * Simply return the value from the head of the list, list should remain unchanged
         * throw exception if list is empty.
	 */
	public T peek() throws EmptyQueueException {
		/* TODO: Implement this method */
		/* Hint: Which method in LinkedList.java already accomplishes this? */
		/* What should you do if the queue is empty? */
		if(list.size() == 0){
			throw new EmptyQueueException("Queue is empty");
		}
		return list.front().value();
	}
}

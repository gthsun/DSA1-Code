package sclist;

/**
 * 
 * @author Mark Floryan
 *
 */
public class ListNode<T> {
	
	/* Data being stored in this node */
	private T data;
	
	/* Reference to the next node in the list */
	protected ListNode<T> next;

	
	public ListNode(T data, ListNode<T> node) {
		this.data = data;
		this.next = node;
	}
	
	/* Getters */
	public T getData() { return this.data; }
}

//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//Homework: HW12 - Priority Queues
//Resources Used: ChatGPT for debugging purposes - helped with dealing with Comparable with generics

package pq;
@SuppressWarnings("unchecked")

/**
 * Interface for a generic priority queue data-structure
 * @author Briana Morrison
 *
 * @param <T> datatype stored in priority queue
 */

public interface SimplePQ<T> {
    /**
     * Add the given element to the priority queue
     * @param t new element
     */
    public void add(T t);

    /**
     * Remove all elements from the priority queue; clear it
     */
    public void clear();

    /**
     * return true iff this value is already in the priority queue
     * @param o an element
     */
    public boolean contains(Object o);

    /**
     * returns item with highest priority; null if priority queue is empty; no change to priority queue
     * @return element
     */
    public T peek();

    /**
     * removes and returns item with highest priority; null if priority queue is empty
     * @return element
     */
    public T remove();

    /**
     * return the number of elements in the priority queue
     * @return number of elements
     */
    public int size();
}

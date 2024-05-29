//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//Homework: HW 6 - Vectors
//Resources: None

//Vector package
package vector;

//Import statements
import java.sql.SQLOutput;
import java.util.Arrays;

//A class used to create a simpler version of an ArrayList
@SuppressWarnings({"unchecked"})
public class Vector<T> implements SimpleList<T> {

	/*
	Instance Variables:
	itemArray: T[] - An array of generics that stores values for the vector and is
	manipulated by the methods below
	size: int - An integer value representing the amount of values within the Vector
	INITIAL_CAPACITY: int - A class variable used to represent the initial length
	itemArray should start with
	 */
	private T[] itemArray;
	private int size = 0;
	private static final int INITIAL_CAPACITY = 100;

	//Default constructor
	public Vector() {
		this(INITIAL_CAPACITY);  // calls the other constructor that takes an int parameter
	}

	//1-argument constructor: initializes itemArray with length of input capacity and sets size to 0
	public Vector(int capacity) {
		this.itemArray = (T[]) new Object[capacity];
		this.size = 0;
	}

	//Represents the actual entire length of itemArray, including the empty elements
	public int capacity() {
		return this.itemArray.length;
	}

	//Returns the array, itemArray, used to contain the values of the vector
	public T[] getItemArray(){
		return itemArray;
	}

	/**
	 * When the underlying array fills up, we need to somehow resize it to accommodate the
	 * Vectors's elements.
	 * Ignores the request if the requested new capacity is too small to fit the elements
	 * already in the Vector
	 */
	public void resize(int newCapacity) {
		if(newCapacity > size){
			T[] itemArray2 = (T[]) new Object[newCapacity];
			for(int i = 0; i < size; i++){itemArray2[i] = itemArray[i];}
			itemArray = itemArray2;
		}
	}

	/**
	 * Returns the number of items in this Vector
	 * @return number of items in this Vector
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Changes the Vector so that it contains zero items
	 */
	@Override
	public void clear() {
		this.itemArray = (T[]) new Object[0];
		size = 0;

	}

	/**
	 * Inserts new item at the end of the Vector
	 * @param item item to be inserted
	 */
	@Override
	public void insertAtTail(T item) {
		//Checks and resizes the array if necessary
		if(capacity() <= size){
			resize(capacity()*2);
		}
		itemArray[size++] = item;
	}


	/**
	 * Inserts item at the beginning of the Vector
	 * @param item item to be inserted
	 */
	@Override
	public void insertAtHead(T item) {
		//Checks and resizes the array if necessary
		if(capacity() <= size){
			resize(capacity()*2);
		}
		for(int i = size; i > 0; i--){
			itemArray[i] = itemArray[i-1];
		}
		itemArray[0] = item;
		size++;
	}

	/**
	 * Inserts item such that index becomes the position of the newly inserted item
	 * @param item item to be inserted
	 * @param index location of insertion
	 */
	@Override
	public void insertAt(int index, T item) {
		//Checks and resizes the array if necessary
		if(capacity() <= size){
			resize(capacity()*2);
		}
		if(index <= size){
			for(int i = size; i > index; i--){
				itemArray[i] = itemArray[i-1];
			}
			itemArray[index] = item;
			size++;
		}
	}

	/**
	 * Remove item at end of Vector
	 * @return item that is removed
	 */
	@Override
	public T removeAtTail() {
		T item = itemArray[size-1];
		itemArray[size-1] = null;
		size--;
		return item;
	}

	/**
	 * Remove item at start of Vector
	 * @return item that is removed
	 */
	@Override
	public T removeAtHead() {
		T item = itemArray[0];
		size--;
		for(int i = 0; i < size; i++){
			itemArray[i] = itemArray[i+1];
		}
		return item;
	}

	/**
	 * Searches for item in Vector
	 * @param item to be found
	 * @return index of first occurrence of the item in the list, or -1 if not present
	 */
	@Override
	public int find(T item) {
		for(int i = 0; i < size; i++){
			if(itemArray[i].equals(item)){return i;}
		}
		return -1;
	}

	/**
	 * Returns the item at the given index, null if anything goes wrong (index out of bounds, empty list, etc.)
	 * @param index position to be retrieved
	 * @return item at the given index, null if anything goes wrong
	 */
	@Override
	public T get(int index) {
		return itemArray[index];
	}

	/**
	 * This toString() method allow you to print a nicely formatted version of your Vector. E.g.
	 *     System.out.println( myVector );
	 * It uses utility methods in the Java Arrays library.
	 */
	@Override
	public String toString() {
//		return Arrays.toString(this.itemArray); // prints entire array from 0 to capacity-1
		return Arrays.toString(Arrays.copyOfRange(this.itemArray, 0, this.size)); // prints from 0 to size-1
	}

}

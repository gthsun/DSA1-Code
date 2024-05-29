//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//Homework: HW12 - Priority Queues
//Resources Used: ChatGPT for debugging purposes - helped with dealing with Comparable with generics

package pq;
@SuppressWarnings("unchecked")

//A Priority Queue that stores and removes values based on their priority, implemented with a Heap
public class MyPriorityQueue<T extends Comparable<T>> implements SimplePQ<T>{

    //Instance variables
    private int currentCapacity; //Capacity of array
    private int size; //Number of elements in PQ
    private T[] heap; //Array used for the heap

    public MyPriorityQueue(){ //Default constructor
        this(10);
    }

    public MyPriorityQueue(int capacity){ //Overloaded constructor
        heap = (T[]) new Comparable[capacity]; //Creates new heap array with parameter capacity
        currentCapacity = capacity; //Current capacity is set to parameter capacity
        size = 0; //Size is set to 0 (no elements yet)
    }

    //Resizes heap array if size gets too close to the array's capacity
    public void resize(int newCapacity) {
        if (newCapacity > size + 1) { //Ensures new capacity is larger than size
            T[] heap2 = (T[]) new Comparable[newCapacity]; //Creates heap array with new capacity
            for(int i = 1; i <= size; i++){
                heap2[i] = heap[i]; //Copies all the elements (shallow copies)
            }
            currentCapacity = newCapacity;
            heap = heap2; //Shallow copy of new heap onto instance heap
        }
    }

    public int getParent(int i) { return ( i / 2 ); } //Gives index of parent
    public int getLeftChild(int i) { return ( i*2 ); } //Gives index of left child
    public int getRightChild(int i) { return ( i*2+1 ); } //Gives index of right child


    //Adds a new element into the PQ
    public void add(T t) {
        if(size+1 >= currentCapacity) resize(currentCapacity*2); //Resize if necessary
        heap[++size] = t; //Increment size and add t to the heap

        //Sort newly added t up the heap until it is in the correct spot
        int index = size;
        while((index > 1) && (heap[index].compareTo(heap[getParent(index)]) > 0)){
            T temp = heap[getParent(index)];
            heap[getParent(index)] = heap[index];
            heap[index] = temp;
            index = getParent(index);
        }
    }

    //Clears heap (size set to 0)
    public void clear() {
        size = 0;
    }

    //Checks if heap contains parameter object
    public boolean contains(Object o) {
        for(int i = 1; i <= size; i++){
            if(heap[i].equals(o)){
                return true;
            }
        }
        return false;
    }

    //Returns the top element of the heap, if not returns null
    public T peek() {
        if(size == 0){
            return null;
        }
        return heap[1];
    }

    //Removes an element from the heap
    public T remove() {
        //Stores the removed element
        if(size == 0) return null;

        //Brings last element to root
        T data = heap[1];
        heap[1] = heap[size];
        size--; //Decrement size

        //Find if it is necessary to initially sort and which child would then be sorted
        int index = 1;
        int child = 0;
        if(getLeftChild(index) <= size){
            if(getRightChild(index) <= size) {
                int c = heap[getLeftChild(index)].compareTo(heap[getRightChild(index)]);
                if (c > 0) child = getLeftChild(index);
                else child = getRightChild(index);
            } else{
                child = getLeftChild(index);
            }
        } else return data;

        //Sort the heap until the "root" has been moved to its appropriate position
        while(heap[index].compareTo(heap[child]) < 0){
            T temp = heap[child];
            heap[child] = heap[index];
            heap[index] = temp;
            index = child;

            //Recalculate if it is necessary to sort and which child would then be sorted
            if(getLeftChild(index) <= size){
                if(getRightChild(index) <= size) {
                    int c = heap[getLeftChild(index)].compareTo(heap[getRightChild(index)]);
                    if (c > 0) child = getLeftChild(index);
                    else child = getRightChild(index);
                } else{
                    child = getLeftChild(index);
                }
            } else return data;
        }
        return data;
    }

    public int size() { //Return the number of elements
        return size;
    }

    public String toString(){ //String representation of PQ
        if(size == 0){
            return "Empty";
        }
        String s = "";
        for(int i = 1; i < size; i++){
            s += heap[i] + ", ";
        }
        return s + heap[size];
    }
}

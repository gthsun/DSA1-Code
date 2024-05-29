//Name: Geethan Sundaram
//Computing ID: mhy9qc@virginia.edu
//Homework: HW11 - HashTable
//Resources Used: None

package hash;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Hash Table implementation.
 *
 * @param <K>
 * @param <V>
 */
public class HashTable<K,V> implements SimpleMap<K,V>{

    private static final int INITIAL_CAP = 5;  // a default initial capacity (set low for initial debugging)
    private int currentCapacity = INITIAL_CAP;
    /*
     * Here are some hints about how to declare your hash table.
     * If you're using an ArrayList, it might look like this:
     * 		private ArrayList<HashNode<K, V>> table;
     * Note that you cannot declare an array of generics (i.e., an array of HashNodes) like this:
     *          private LinkedList<HashNode<K,V>>[] table;
     * but see here https://programming.guide/java/generic-array-creation.html for workarounds.
     */

    /* YOU WILL LIKELY WANT MORE PRIVATE VARIABLES HERE */
    private int size = 0; //The number of elements in the HashTable

    //An ArrayList of LinkedLists intended to store the elements of the HashTable
    private ArrayList<LinkedList<HashNode<K, V>>> hashTable;

    //Default Constructor, uses overloaded constructor with INITIAL_CAP
    public HashTable() {  // default constructor sets capacity to default value
        this(INITIAL_CAP);
    }

    //Overloaded Constructor
    public HashTable(int capacity) {  // constructor sets capacity to given value
        hashTable = new ArrayList<LinkedList<HashNode<K, V>>>(capacity); //Instantiates ArrayList
        for(int i = 0; i < capacity; i++){
            hashTable.add(new LinkedList<HashNode<K, V>>()); //Populates up to capacity with empty Linked lists
        }
        currentCapacity = capacity; //Sets currentCapacity to the declared capacity
        this.size = 0; //No elements yet, so size is 0
    }

    //Resizes the hashtable arrayList with a new capacity
    public void resize(){
        double loadFactor = (double)size/currentCapacity; //Calculate load factor
        if(loadFactor > 0.75) {
            int newCapacity = currentCapacity*2 + 1;
            ArrayList<LinkedList<HashNode<K, V>>> hashTable2 =
                    new ArrayList<LinkedList<HashNode<K, V>>>(currentCapacity);
            for (int i = 0; i < currentCapacity; i++) {
                hashTable2.add(hashTable.get(i)); //Creates a deep copy of current hashTable
            }
            //HashTable with new capacity
            hashTable = new ArrayList<LinkedList<HashNode<K, V>>>(newCapacity);
            //Populate the hashTable with LinkedLists up to the new capacity
            for (int i = 0; i < newCapacity; i++) {
                hashTable.add(new LinkedList<HashNode<K, V>>());
            }
            currentCapacity = newCapacity; //current capacity is set to the new capacity
            size = 0; //size should be set to 0 before repopulating

            //New capacity is used to properly insert all nodes from old hashTable (deepcopy)
            //into their new indexes (through hashing)
            for (int index = 0; index < hashTable2.size(); index++) {
                for (int i = 0; i < hashTable2.get(index).size(); i++) {
                    K key = hashTable2.get(index).get(i).getKey();
                    V value = hashTable2.get(index).get(i).getValue();
                    insert(key, value);
                }
            }
        }

    }

    //Returns the number of elements in the HashTable
    public int getSize() { return size; }

    // insert() adds a new key/value pair if the key is not found, otherwise it replaces
    // the existing key's value
    @Override
    public void insert(K key, V value) {
        int index = Math.abs(key.hashCode() % currentCapacity); //Obtain index through hash function
        //^SHOULD BE ABS VALUE TO ACCOUNT FOR NEGATIVE HASHCODES^

        for(int i = 0; i < hashTable.get(index).size(); i++){
            if(key.equals(hashTable.get(index).get(i).getKey())){ //If input key equals another key
                hashTable.get(index).get(i).setValue(value); //Replace the value at that key with input value
                return; //Break out of method, promotes efficiency
            }
        }
        //If no equal key found, insert key at that index of LinkedList
        hashTable.get(index).addFirst(new HashNode<K, V>(key, value));
        this.size++; //Increment size due to new array
        resize();
    }

    //Finds and returns a value at a given key, else returns null
    @Override
    public V retrieve(K key) {
        int index = Math.abs(key.hashCode() % currentCapacity); //Obtain index through hash function
        for(int i = 0; i < hashTable.get(index).size(); i++){
            if(key.equals(hashTable.get(index).get(i).getKey())){
                return hashTable.get(index).get(i).getValue(); //If keys match, return value
            }
        }
        return null; //Else, return null
    }

    //Finds and returns whether a value was found at a key (true or false)
    @Override
    public boolean contains(K key) {
        int index = Math.abs(key.hashCode() % currentCapacity); //Obtain index through hash function
        for(int i = 0; i < hashTable.get(index).size(); i++){
            if(key.equals(hashTable.get(index).get(i).getKey())){
                return true; //If keys match, return true
            }
        }
        return false;
    }

    //Removes an element from the table given its key
    @Override
    public void remove(K key) {
        int index = Math.abs(key.hashCode() % currentCapacity); //Obtain index through hash function
        for(int i = 0; i < hashTable.get(index).size(); i++){
            if(key.equals(hashTable.get(index).get(i).getKey())){
                hashTable.get(index).remove(i); //Remove element from LinkedList if key matches
                size--;
                return; //Stop method to promote efficiency
            }
        }
    }


    /*
     * OPTIONAL HELPER METHODS: The next two methods will let you print out your
     * entire hash table, or let you make sure all keys that hash to a single
     * bucket's index get stored as they should in your table. You'll need to
     * implement the second method; it depends on how you store entries and
     * handle collisions. This is NOT required, but you may find it helpful when
     * debugging and testing your code.
     */

    public void printHashTable() {
        for (int idx=0; idx < this.currentCapacity; ++idx) {
            System.out.print(idx + ": ");
            printEntriesByIndex(idx);
        }
    }

    private void printEntriesByIndex(int idx) {
        /*
         * To implement this method to help print out one bucket of your hash table, you need to determine:
         * a) If there are no key/value pairs in the bucket idx, print "no entries"
         * b) If there are key/value pairs at that bucket, use a loop to print each one.
         *    Best to use System.out.print() and not println() so they're all on one line.
         * c) At the end of that loop, do System.out.println() to print a new line.
         */
        if(hashTable.get(idx).size() == 0){
            System.out.println("No entries");
        } else{
            for(int i = 0; i < hashTable.get(idx).size(); i++){
                System.out.print("<" +hashTable.get(idx).get(i).getKey()+ ", " +hashTable.get(idx).get(i).getValue()+ ">");
            }
            System.out.println();
        }
    }

}


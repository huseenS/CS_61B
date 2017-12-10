/* HashTableChained.java */

package dict;
import java.util.LinkedList;

/**
 *  HashTableChained implements a Dictionary as a hash table with chaining.
 *  All objects used as keys must have a valid hashCode() method, which is
 *  used to determine which bucket of the hash table an entry is stored in.
 *  Each object's hashCode() is presumed to return an int between
 *  Integer.MIN_VALUE and Integer.MAX_VALUE.  The HashTableChained class
 *  implements only the compression function, which maps the hash code to
 *  a bucket in the table's range.
 *
 *  DO NOT CHANGE ANY PROTOTYPES IN THIS FILE.
 **/

public class HashTableChained implements Dictionary {

  /**
   *  Place any data fields here.
   **/
	//array of list
	private LinkedList<Entry>[] table;
	private static final float lOAD_FACTOR = 0.75f;
	private int size; //number of elements

  /** 
   *  Construct a new empty hash table intended to hold roughly sizeEstimate
   *  entries.  (The precise number of buckets is up to you, but we recommend
   *  you use a prime number, and shoot for a load factor between 0.5 and 1.)
   **/

  @SuppressWarnings("unchecked")
public HashTableChained(int sizeEstimate) {
	  int sizeOfArray = (int)(sizeEstimate/lOAD_FACTOR);
	  table = (LinkedList<Entry>[]) new LinkedList<?>[sizeOfArray];
	  size = 0;
	  
	  for (int i = 0; i < table.length; i++) {
		table[i] = new LinkedList<>();	
	  }
  }

  /** 
   *  Construct a new empty hash table with a default size.  Say, a prime in
   *  the neighborhood of 100.
   **/

  public HashTableChained() {
	  this(101);
    // Your solution here.
  }

  /**
   *  Converts a hash code in the range Integer.MIN_VALUE...Integer.MAX_VALUE
   *  to a value in the range 0...(size of hash table) - 1.
   *
   *  This function should have package protection (so we can test it), and
   *  should be used by insert, find, and remove.
   **/

  int compFunction(int code) {
	  return code % table.length;
  }

  /** 
   *  Returns the number of entries stored in the dictionary.  Entries with
   *  the same key (or even the same key and value) each still count as
   *  a separate entry.
   *  @return number of entries in the dictionary.
   **/

  @Override
public int size() {
    // Replace the following line with your solution.
    return size;
  }

  /** 
   *  Tests if the dictionary is empty.
   *
   *  @return true if the dictionary has no entries; false otherwise.
   **/

  @Override
public boolean isEmpty() {
	 if (size == 0) {
		return true;
	}
    return false;
  }

  /**
   *  Create a new Entry object referencing the input key and associated value,
   *  and insert the entry into the dictionary.  Return a reference to the new
   *  entry.  Multiple entries with the same key (or even the same key and
   *  value) can coexist in the dictionary.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the key by which the entry can be retrieved.
   *  @param value an arbitrary object.
   *  @return an entry containing the key and value.
   **/

  @Override
public Entry insert(Object key, Object value) {
	  //check if key exists
	  if (key != null) {
		int index = compFunction(key.hashCode());
		//new Entry Object
		Entry toInsert = new Entry();
		toInsert.key = key;
		toInsert.value = value;
		//add at position n
		table[index].add(toInsert);
		size++; //increment size
		return toInsert;
	  }
    return null;
  }

  /** 
   *  Search for an entry with the specified key.  If such an entry is found,
   *  return it; otherwise return null.  If several entries have the specified
   *  key, choose one arbitrarily and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   **/

  @Override
public Entry find(Object key) {
	  int indexOfKey = compFunction(key.hashCode());
	  
	  for (Entry entry : table[indexOfKey]) {
		if (entry.key.equals(key)) {
			return entry;
		}
	}
	 //key not found 
    return null;
  }

  /** 
   *  Remove an entry with the specified key.  If such an entry is found,
   *  remove it from the table and return it; otherwise return null.
   *  If several entries have the specified key, choose one arbitrarily, then
   *  remove and return it.
   *
   *  This method should run in O(1) time if the number of collisions is small.
   *
   *  @param key the search key.
   *  @return an entry containing the key and an associated value, or null if
   *          no entry contains the specified key.
   */

  @Override
public Entry remove(Object key) {
    int indexOfkey = compFunction(key.hashCode());
    
    Entry toDelete = null;
    for (Entry entry : table[indexOfkey]) {
    	//key found
		if (entry.key.equals(key)) {
			toDelete = entry;
			break; //break to delete first found
		}
	}
    //key not found
    if (toDelete == null) {
		return null;
	}
    table[indexOfkey].remove(toDelete); //delete entry object from list
    return toDelete;
  }

  /**
   *  Remove all entries from the dictionary.
   */
  @Override
public void makeEmpty() {
    //iterate over table
    //instantiate every list as empty
	  for (int i = 0; i < table.length; i++) {
		LinkedList<Entry> linkedList = table[i];
		linkedList = new LinkedList<>();
	}
  }

}

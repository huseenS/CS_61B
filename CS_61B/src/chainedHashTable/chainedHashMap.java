package chainedHashTable;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
/**
 * 
 * @author Huseen Sufi
 *
 * @param <K>
 * @param <V>
 * HashTable using Separate Chaining (Linked List in each bucket)
 * to resolve collisions
 */
public class chainedHashMap<K,V> implements Map<K,V> {
	
	protected LinkedList<hashEntry<K,V>>[] bucketArray;
	protected static final double loadFactor = 0.75;
	protected int size = 0;
	
	@SuppressWarnings({ "unchecked"})
	public chainedHashMap(int initialCapacity) {
		int sizeOfArray = (int) (initialCapacity/loadFactor);
		 bucketArray = (LinkedList<hashEntry<K,V>>[]) new LinkedList<?>[sizeOfArray];
		for (int i = 0; i < bucketArray.length; i++) {
			bucketArray[i] = new LinkedList<>();
		}
	}
	
/**
 * *
 * @param key
 * @return int index
 */
	private int indexOf(Object key) {
        int k = Math.abs(key.hashCode() % bucketArray.length);
        if (k >= bucketArray.length)
            k = k - ((k / bucketArray.length) * bucketArray.length);
        return k;
    }

	
	@Override
	public void clear() {
		for (int i = 0; i < bucketArray.length; i++) {
			bucketArray[i].clear();
		}
		size = 0;
		
	}

	@Override
	public boolean containsKey(Object key) {
		return (get(key) != null);
	}

	@Override
	public boolean containsValue(Object value) {
		//TODO
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Set<Entry<K, V>> entrySet() {
		Set<Entry<K, V>> set = new HashSet<>();
		//iterate over lists
		for (LinkedList<hashEntry<K, V>> list : bucketArray) {
			//iterate over each hashEntry
			for (hashEntry<K, V> hashEntry : list) {
				set.add((Entry<K, V>) hashEntry);
			}
		}		
		return set;
	}

	@Override
	public V get(Object key) {
		if (key != null) {
			int index = indexOf(key);
			LinkedList<hashEntry<K, V>> list = bucketArray[index];
			for (hashEntry<K, V> hashEntry : list) {
				if (hashEntry.key().equals(key)) {
					return hashEntry.value();
				}
			}
		}
		return null; //key not found
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		int index = indexOf(key);
		//new HashEntry
		hashEntry<K, V> toAdd = new hashEntry<>();
		toAdd.key = key;
		toAdd.value = value;
		LinkedList<hashEntry<K, V>> list = bucketArray[index];
		hashEntry<K, V> prev = new hashEntry<>();
		prev.value = null;
		boolean exist = false;
		//don't add any duplicates
		for (hashEntry<K, V> h : list) {
			if (h.key().equals(toAdd.key)) {
				prev.value = h.value();
				prev.key = h.key();
				h.value = toAdd.value(); //set
				exist = true;
				break;
			}
		}
		//not found
		if (!exist) {
			list.add(toAdd);
		}
		size++;
		return prev.value;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		//
	}

	@Override
	public V remove(Object key) {
		int index = indexOf(key);
		LinkedList<hashEntry<K, V>> list = bucketArray[index];
		for (hashEntry<K, V> h : list) {
			if (h.key().equals(key)) {
				list.remove(h); //remove from list
				size--;
				V value = h.value; //save value
				//remove key/value pair
				h.key = null;
				h.value = null;
				return value;
			}
		}
		//not found
		return null;
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		//iterate over each list
		for (int key = 0; key < this.bucketArray.length; key++) {
			LinkedList<hashEntry<K, V>> list = this.bucketArray[key];
			//iterate over items in list
			for(int item = 0; item < list.size(); item++) {
				hashEntry<K, V> h = list.get(item);
				sb.append(h.key()).append("=").append(h.value()).append(",");
			}
		}
		return sb.toString();
	}
}
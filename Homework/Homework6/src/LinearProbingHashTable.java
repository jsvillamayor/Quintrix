import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinearProbingHashTable<K, V> implements GradableMap<K, V>{
	
	private HashTableEntry<K, V>[] hashTable;
	private double maxLoadFactor;
	private int currentSize, maxSize;
	
	/**
	 * 
	 * {@summary
	 * Constructs a new, empty hash table with default capacity of 11 and load factor of 0.75
	 * }
	 * 
	 */
	@SuppressWarnings("unchecked")
	public LinearProbingHashTable(){
		HashTableEntry<K,V> hashTable[] = new HashTableEntry[11];
		this.maxLoadFactor = 0.75;
	}
	
	/**
	 * 
	 * {@summary
	 * Constructs a new, empty hash table with a specified capacity and specified load factor
	 * }
	 * 
	 * @param maxSize the initial max capacity of the hash table
	 * @param maxLoadFactor the load factor of the hash table
	 */
	@SuppressWarnings("unchecked")
	public LinearProbingHashTable(int maxSize, double maxLoadFactor){
		this.maxSize = maxSize;
		HashTableEntry<K, V> hashTable[] = new HashTableEntry[maxSize];
		this.maxLoadFactor = maxLoadFactor;
	}

	/**
	 * 
	 * {@summary
	 * Constructs a new, empty hash table with a specified capacity and a default load factor of 0.75
	 * }
	 * 
	 * @param maxSize the initial max capacity of the hash table
	 */
	@SuppressWarnings("unchecked")
	public LinearProbingHashTable(int maxSize){
		this.maxSize = maxSize;
		HashTableEntry<K, V> hashTable[] = new HashTableEntry[maxSize];
		this.maxLoadFactor = 0.75;
	}
	
	/**
	 * 
	 * {@summary
	 * Clears the hash table so that it has no key/value pairs
	 * }
	 * 
	 */
	@Override
	public void clear() {
		for(int i = 0; i < maxSize ; i++) {
			hashTable[i] = null;
		}
		this.currentSize = 0;
	}
	
	/**
	 * 
	 * {@summary
	 * Tests if specified object is a key in hash table
	 * }
	 * 
	 * @param Object possible key
	 * 
	 * @return true if the specified object is a key in the hash table
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean containsKey(Object key) {
		HashTableEntry temp = new HashTableEntry(key, null);
		int tempHash = temp.hashCode() % maxSize;
		for(int i = 0; i < maxSize; i++) {
			if(hashTable[tempHash].getKey() == null)
				return false;
			if(hashTable[tempHash].getKey() == key)
				return true;
		}
		return false;
	}
	
	/**
	 * 
	 * {@summary
	 * Tests if specified object is a value in the hash table
	 * }
	 * 
	 * @param value possible value
	 * 
	 * @return true if the specified object is a value in the hash table
	 * 
	 */
	@Override
	public boolean containsValue(Object value) {
		for(int i = 0; i < maxSize; i++) {
			if(hashTable[i].getValue() == value)
				return true;
		}
		return false;
	}
	
	/**
	 * 
	 * {@summary
	 * Returns a set of all the key/value pairs in the hash table
	 * }
	 * 
	 * @return a set of the key/value pairs in the hash table
	 * 
	 */
	@Override
	public Set<Map.Entry<K, V>> entrySet(){
		Set<Map.Entry<K, V>> set = new HashSet<Map.Entry<K, V>>();
		for(int i = 0; i < maxSize; i++) {
			if(!hashTable[i].isAvailable() && hashTable[i] != null)
				set.add(hashTable[i]);
		}
		return set;
	}
	
	/**
	 * 
	 * {@summary
	 * Returns the value of the specified key in the hash table or null if no such key is in hash table
	 * }
	 * 
	 * @throws NullPointerException if specified key is null
	 * @param key the key whose value is to be returned
	 * @return the value of the key specified in the hash table
	 */

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public V get(Object key) {
		if(key == null)
			throw new NullPointerException();
		HashTableEntry<K,V> temp = new HashTableEntry(key, null);
		int tempHash = temp.hashCode() % maxSize;
		for(int i = 0; i < maxSize; i++) {
			if(hashTable[tempHash].getKey() == null)
				return null;
			if(hashTable[tempHash].getKey() == key)
				return hashTable[tempHash].getValue();
			if(hashTable[tempHash].isAvailable()) {
				tempHash++;
				tempHash = tempHash % maxSize;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * {@summary
	 * Tests if this hash table has no keys
	 * }
	 * 
	 * @return true if there are no key/value pairs in hash table
	 * 
	 */
	@Override
	public boolean isEmpty() {
		if(currentSize == 0)
			return true;
		else
			return false;
	}
	
	/**
	 * 
	 * {@summary
	 * Returns a sat of all the keys stored in the hash table
	 * }
	 * 
	 * @return a set of all the key values in the hash table
	 * 
	 */
	@Override
	public Set<K> keySet(){
		Set<K> set = new HashSet<K>();
		for(int i = 0; i < maxSize; i++) {
			if(!hashTable[i].isAvailable() && hashTable[i] != null)
				set.add(hashTable[i].getKey());
		}
		return set;
	}

	/**
	 * 
	 * {@summary
	 * Maps the specified key/value pair into the hash table using linear probing
	 * }
	 * 
	 * @throws NullPointerException if key is null
	 * @param key the key to be stored
	 * @param value the value to be stored
	 * @return returns null of key was not previously in the table or the old value if key exists and value is being overwritten
	 * 
	 */
	@SuppressWarnings({ "unchecked" })
	@Override
	public V put(K key, V value) {
		if(key == null) 
			throw new NullPointerException();
		HashTableEntry<K, V> temp = new HashTableEntry<K, V>(key, value);
		int tempHash = temp.hashCode() % maxSize;
		boolean added = false;
		if(currentSize / maxSize > maxLoadFactor) {
			this.resize();
		}
		if(hashTable[tempHash] == null) {
			hashTable[tempHash] = temp;
			currentSize++;
			return null;
		}
		else {
			//replacing value with existing Key value
			if(key == hashTable[tempHash].getKey()) {
				Object oldValue = hashTable[tempHash].getValue();
				hashTable[tempHash] = temp;
				return (V) oldValue;
			}
			//Adding value to index that previously had an entry
			if(hashTable[tempHash].isAvailable()) {
				hashTable[tempHash] = temp;
				currentSize++;
				return null;
			}
			else {
				while(!added) {
					tempHash++;
					tempHash = tempHash % maxSize;
					if(key == hashTable[tempHash].getKey()) {
						Object oldValue = hashTable[tempHash].getValue();
						hashTable[tempHash] = temp;
						return (V) oldValue;
					}
					if(hashTable[tempHash].isAvailable()) {
						hashTable[tempHash] = temp;
						currentSize++;
						return null;
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * 
	 * {@summary
	 * Puts all mappings from other map into hash table
	 * }
	 * 
	 * @param otherMap Map to be stored in hash table
	 * 
	 */
	public void putAll(Map<? extends K, ? extends V> otherMap) {
		for(Entry<? extends K, ? extends V> temp : otherMap.entrySet()) {
			this.put(temp.getKey(), temp.getValue());
		}
	}
	
	/**
	 * 
	 * {@summary
	 * Removes the key/value pair by setting availability flag of entry to true. Returns value of key/value pair being removed 
	 * }
	 * 
	 * @throws NullPointerException if the key is null
	 * @param key The key of the key/value pair to be removed from the hash table
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public V remove(Object key) {
		if(key == null)
			throw new NullPointerException();
		HashTableEntry<K, V> temp = new HashTableEntry(key, null);
		int tempHash = temp.hashCode() % maxSize;
		for(int i = 0; i < maxSize; i++) {
			if(hashTable[tempHash].getKey() == key) {
				hashTable[tempHash].setAvailable(true);
				currentSize--;
				return hashTable[tempHash].getValue();
			}
			if(hashTable[tempHash] == null)
				return null;
			if(hashTable[tempHash].isAvailable()) {
				tempHash++;
				tempHash = tempHash % maxSize;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * {@summary
	 * Returns a collection of all the values in the hash table
	 * }
	 * 
	 * @return A collection of all the values in the hash table
	 * 
	 */
	public Collection<V> values(){
		Collection<V> collection = new ArrayList<V>();
		for(int i = 0; i < maxSize; i++) {
			if(!hashTable[i].isAvailable() && hashTable[i] != null)
				collection.add(hashTable[i].getValue());
		}
		return collection;
	}
	
	/**
	 * 
	 * {@summary
	 * Returns how many elements are stored in the hash table
	 * }
	 * 
	 * @return The amount of key/value pairs stored in the hash table
	 * 
	 */
	@Override
	public int size() {
		return currentSize;
	}
	
	/**
	 * 
	 * {@summary
	 * Resizes the max size of the hash table by doubling the max size
	 * }
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void resize() {
		int oldMaxSize = maxSize;
		maxSize = maxSize * 2;
		HashTableEntry[] tempHashTable = new HashTableEntry[maxSize];
		System.arraycopy(hashTable, 0, tempHashTable, 0, oldMaxSize);
		hashTable = tempHashTable;
		clear();
		for(int i = 0; i < oldMaxSize; i++) {
			put((K)tempHashTable[i].getKey(), (V)tempHashTable[i].getValue());
		}
	}

	/**
	 * 
	 * {@summary
	 * Returns an array of all the entries in the hash table
	 * }
	 * 
	 * @return An array of all the entries in the hash table
	 * 
	 */
	@Override
	public HashTableEntry<K, V>[] getArray() {
		return hashTable;
	}

	/**
	 * 
	 * {@summary
	 * Sets a hash table with specified array of entries
	 * }
	 * 
	 * @param array Array of entries to be put into hash table
	 * 
	 */
	@Override
	public void setArray(HashTableEntry<K, V>[] array) {
		this.hashTable = array;
	}

	/**
	 * 
	 * {@summary
	 * Sets the max size of the hash table
	 * }
	 * 
	 * @param size The max size of hash table
	 * 
	 */
	@Override
	public void setSize(int size) {
		this.maxSize = size;
	}
	
}

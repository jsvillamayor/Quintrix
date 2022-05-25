import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LinearProbingHashTable<K, V> implements GradableMap<K, V>{
	
	private HashTableEntry<K, V>[] hashTable;
	private double maxLoadFactor;
	private int currentSize, maxSize;
	
	@SuppressWarnings("unchecked")
	public LinearProbingHashTable(){
		HashTableEntry<K,V> hashTable[] = new HashTableEntry[11];
		this.maxLoadFactor = 0.75;
	}
	
	@SuppressWarnings("unchecked")
	public LinearProbingHashTable(int maxSize, double maxLoadFactor){
		this.maxSize = maxSize;
		HashTableEntry<K, V> hashTable[] = new HashTableEntry[maxSize];
		this.maxLoadFactor = maxLoadFactor;
	}

	@SuppressWarnings("unchecked")
	public LinearProbingHashTable(int maxSize){
		this.maxSize = maxSize;
		HashTableEntry<K, V> hashTable[] = new HashTableEntry[maxSize];
		this.maxLoadFactor = 0.75;
	}
	
	@Override
	public void clear() {
		for(int i = 0; i < maxSize ; i++) {
			hashTable[i] = null;
		}
		this.currentSize = 0;
	}
	
	/**
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
	 * @param key
	 * @return
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
	 */
	public void putAll(Map<? extends K, ? extends V> otherMap) {
		for(Entry<? extends K, ? extends V> temp : otherMap.entrySet()) {
			this.put(temp.getKey(), temp.getValue());
		}
	}
	
	/**
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
	
	public Collection<V> values(){
		Collection<V> collection = new ArrayList<V>();
		for(int i = 0; i < maxSize; i++) {
			if(!hashTable[i].isAvailable() && hashTable[i] != null)
				collection.add(hashTable[i].getValue());
		}
		return collection;
	}
	
	@Override
	public int size() {
		return currentSize;
	}
	
	/**
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
	 */
	@Override
	public HashTableEntry<K, V>[] getArray() {
		return hashTable;
	}

	/**
	 * 
	 */
	@Override
	public void setArray(HashTableEntry<K, V>[] array) {
		this.hashTable = array;
	}

	/**
	 * 
	 */
	@Override
	public void setSize(int size) {
		this.maxSize = size;
	}
	
}

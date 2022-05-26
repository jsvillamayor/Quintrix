import java.util.Map.Entry;

/**
 * 
 * @author James
 *
 *{@summary
 * A HashMap entry
 *}
 *
 * @param <K> Generic key for hash map entry
 * @param <V> Generic value for hash map entry
 */
public class HashTableEntry<K, V> implements Entry<K, V>{

	private K key;
	private V value;
	private boolean available;
	
	/**
	 * {@summary
	 * Default constructor for HashTableEntry
	 * }
	 */
	public HashTableEntry(){
		
	}
	
	/**
	 * 
	 * {@summary
	 * Constructor with arguments of key/value pair
	 * }
	 * 
	 * @param key The key corresponding to value
	 * @param value The value corresponding to key
	 */
	public HashTableEntry(K key, V value){
		this.key = key;
		this.value = value;
		this.setAvailable(false);
	}

	/**
	 * {@summary
	 * Checks if this key/value pair has been removed from the hashmap
	 * }
	 * 
	 * @return true if this entry has been removed from the hashmap
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * 
	 * {@summary
	 * Setter method for isAvailable instance variable
	 * }
	 * 
	 * @param available availability to be stored for this entry
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	/**
	 * 
	 * {@summary
	 * Compares if an object is equal to the value of this entry
	 * }
	 * 
	 * @return true if the specified object is equal to the value of this entry
	 * 
	 */
	public boolean equals(Object o) {
		if(value.equals(o)) return true;
		else return false;
	}
	
	/**
	 * 
	 * {@summary
	 * Creates a hash code value for this entry
	 * }
	 * 
	 * @return a hash code value for this entry
	 * 
	 */
	public int hashCode() {
		return  (getKey()==null   ? 0 : getKey().hashCode()) ^
                (getValue()==null ? 0 : getValue().hashCode());
	}
	
	/**
	 * 
	 * {@summary
	 * Returns the key of this entry
	 * }
	 * 
	 * @return The key of this entry
	 * 
	 */
	public K getKey() {
		return this.key;
	}
	
	/**
	 * 
	 * {@summary
	 * Returns the value of this entry
	 * }
	 * 
	 * @return The value of this entry
	 * 
	 */
	public V getValue() {
		return this.value;
	}
	
	/**
	 * 
	 * {@summary
	 * Overwrites the value of this entry with value passed as argument. Then returns overwritten value
	 * }
	 * 
	 */
	@SuppressWarnings("unchecked")
	public V setValue(V value) {
		Object temp = this.value;
		this.value = value;
		return (V) temp;
	}
	
	
}

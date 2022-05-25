import java.util.Map.Entry;

public class HashTableEntry<K, V> implements Entry<K, V>{

	private K key;
	private V value;
	private boolean available;
	
	/**
	 * 
	 */
	public HashTableEntry(){
		
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public HashTableEntry(K key, V value){
		this.key = key;
		this.value = value;
		this.setAvailable(false);
	}

	/**
	 * 
	 * @return
	 */
	public boolean isAvailable() {
		return available;
	}

	/**
	 * 
	 * @param available
	 */
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	/**
	 * 
	 */
	public boolean equals(Object o) {
		if(value.equals(o)) return true;
		else return false;
	}
	
	/**
	 * 
	 */
	public int hashCode() {
		return  (getKey()==null   ? 0 : getKey().hashCode()) ^
                (getValue()==null ? 0 : getValue().hashCode());
	}
	
	/**
	 * 
	 */
	public K getKey() {
		return this.key;
	}
	
	/**
	 * 
	 */
	public V getValue() {
		return this.value;
	}
	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public V setValue(V value) {
		Object temp = this.value;
		this.value = value;
		return (V) temp;
	}
	
	
}

import java.util.Map;

/**
 * 
 * @author James
 *
 * @param <K> Generic Key for Map
 * @param <V> Generic Value for Map
 */
public interface GradableMap<K, V> extends Map<K, V>{
	
	public HashTableEntry<K, V>[] getArray();
	
	public void setArray(HashTableEntry<K, V>[] array);
	
	public void setSize(int size);

}

/**
 * 
 * @author James
 *
 *	Homework #3
 *	In this class, we make the ArrayList class from scratch,
 *	using  a generic, so any type of object can be passed
 *	into this ArrayList. This class also implements the interface List
 *
 * @param <T>
 */

public class ArrayList <T> implements List <T>{

	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	private int current_capacity = 11;;
	private T[] data;
	private int size;
	
	/**
	 * Default constructor that automatically sets size to 0
	 * and initializes an array with default capacity
	 */
	public ArrayList() {
		this.size = 0;
		data = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	/**
	 * Constructor that sets size to 0 but now takes in an 
	 * initial capacity parameter and initializes array with
	 * that size
	 * 
	 * @param initialCapacity
	 */
	public ArrayList(int initialCapacity) {
		this.size = 0;
		data = (T[]) new Object[initialCapacity];
		this.current_capacity = initialCapacity;
	}
	
	/**
	 * Doubles the capacity of the array by making a temporary 
	 * array with doubled capacity, copying the original array into it, 
	 * then transferring temporary array into the original one
	 */
	private void regrow() {
		current_capacity = current_capacity * 2;
		T[] temp = (T[]) new Object[current_capacity];
		System.arraycopy(data, 0, temp, 0, size);
		data = temp;
	}
	
	/**
	 * Adds item into ArrayList at index specified in parameter.
	 * Calls the regrow function if ArrayList is full to double capacity.
	 * When item is added, size is increased by 1
	 * 
	 * @param item, index
	 */
	@Override
	public void add(T item, int index) {
		if(index < 0 || index > size) {}
		else {
			if(index == current_capacity)
				regrow();
			if(data[index] == null)
				size++;
			data[index] = item;
		}
	}
	
	/**
	 * Clears ArrayList by turning all entries in ArrayList 
	 * to null and setting size to 0
	 */
	@Override
	public void clear() {
		for(int i = 0; i<size; i++) {
			data[i] = null;
		}
		this.size = 0;
	}
	
	/**
	 * Iterates through all indexes of ArrayList and looks for item.
	 * If found, returns true; if not found, returns false
	 * 
	 * @param item
	 */
	@Override
	public boolean contains(Object item) {
		for(int i = 0; i < size; i++) {
			if (data[i].equals(item))
				return true;
		}
		return false;
		
	}
	
	/**
	 * Goes into ArrayList at specified index from parameter
	 * then returns that object
	 * 
	 * @param index
	 */
	@Override
	public T get(int index) {
		return data[index];
	}
	
	/**
	 * Iterates through ArrayList, looking for match of item
	 * inside of parameter. When found, returns the index.
	 * If not found, returns -1
	 * 
	 * @param item
	 */
	@Override
	public int indexOf(Object item) {
		for(int i = 0; i < size; i++) {
			if(data[i].equals(item))
				return i;
		}
		return -1;
	}
	
	/**
	 * Checks if there are any entries in Arraylist
	 * by looking at size
	 */
	@Override
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}
	
	/**
	 * Returns size of ArrayList
	 */
	@Override
	public int size() {
		return size;
	}
	
}

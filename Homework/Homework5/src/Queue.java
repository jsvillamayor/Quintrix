/**
 * {@summary
 * Form of list where items are added, then the first ones added, 
 * are first ones to be deleted. First in, first out methodology.
 * }
 * @author James
 *
 * @param <T> Generic so any kind of object can be passed into Queue
 */
public class Queue<T> {

	private int maxSize,currentSize;
	@SuppressWarnings("rawtypes")
	private Node head,last;
	
	/**
	 * {@summary 
	 * Default constructor for Queue, setting max&current size to 0
	 * }
	 */
	public Queue() {
		this.currentSize = 0;
		this.maxSize = 0;
	}
	
	/**
	 * {@summary
	 * Constructor for Queue where we set max size to given size in parameter
	 * }
	 * 
	 * @param maxSize given parameter to set max size of Queue
	 */
	public Queue(int maxSize) {
		this.maxSize = maxSize;
		this.currentSize = 0;
	}
	
	/**
	 * {@summary
	 * Setter method to set max size of queue in case if queue
	 * max size ever wants to be changed.
	 * }
	 * 
	 * @param size New size for queue max size
	 */
	public void setMaxSize(int size) {
		this.maxSize = size;
	}
	
	/**
	 * {@summary
	 * Getter method to return the max size of the queue
	 * }
	 * 
	 * @return Max size of queue
	 */
	public int getMaxSize() {
		return maxSize;
	}
	
	/**
	 * {@summary
	 * Getter method to return the current size of the queue
	 * }
	 * 
	 * @return Current size of queue
	 */
	public int getCurrentSize() {
		return currentSize;
	}
	
	/**
	 * {@summary
	 * Checks if queue is empty by checking the current size
	 * }
	 * 
	 * @return True if current size is 0
	 */
	public boolean isEmpty() {
		if(currentSize == 0)
			return true;
		else
			return false;
	}
	
	/**
	 * {@summary
	 * Checks if queue is full by checking the current size
	 * }
	 * 
	 * @return True if current size is equal to max size
	 */
	public boolean isFull() {
		if(currentSize == maxSize)
			return true;
		else
			return false;
	}
	
	/**
	 * {@summary
	 * Shows data of first in queue, but does not remove from queue
	 * }
	 * 
	 * @return Data of first in queue
	 */
	@SuppressWarnings("unchecked")
	public T peek() {
		return (T) head.data;
	}
	
	/**
	 * {@summary
	 * Adds object to queue by creating a node with data 
	 * and adds it as tail of list. Special case if first
	 * item by setting node as head & tail of list
	 * }
	 * 
	 * @param value Object being added to queue
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void add(T value) {
		if(currentSize == maxSize)
			throw new IllegalStateException();
		else {
			Node node = new Node(value);
			if(currentSize == 0) {
				this.head = node;
				this.last = node;
			}
			else {
				node.prev = last;
				node.prev.next = node;
				this.last = node;
			}
			currentSize++;
		}
	}
	
	/**
	 * {@summary
	 * Returns and removes data of first in queue, but also returns null if queue is empty
	 * }
	 * 
	 * @return Data of first in queue, or null if empty
	 */
	@SuppressWarnings("unchecked")
	public T poll() {
		if(currentSize == 0)
			return null;
		T item = (T) head.data;
		this.head = head.next;
		currentSize--;
		return item;
	}
	
	/**
	 * {@summary
	 * Returns and removes data of first in queue
	 * }
	 * 
	 * @return Data of first in queue
	 */
	@SuppressWarnings("unchecked")
	public T remove() {
		T item = (T) head.data;
		this.head = head.next;
		currentSize--;
		return item;
	}
	
}

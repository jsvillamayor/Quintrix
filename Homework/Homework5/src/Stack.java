
public class Stack<T> {

	private int maxSize,currentSize;
	@SuppressWarnings("rawtypes")
	private Node head,last;
	
	/**
	 * {@summary
	 * Default constructor for Stack, setting current& max size to 0
	 * }
	 */
	public Stack() {
		this.maxSize = 0;
		this.currentSize = 0;
	}
	
	/**
	 * {@summary
	 * Constructor for Stack setting max size of Stack to size given in parameter
	 * }
	 * 
	 * @param maxSize Initial max size for Stack
	 */
	public Stack(int maxSize) {
		this.currentSize = 0;
		this.maxSize = maxSize;
	}
	
	/**
	 * {@summary
	 * Adds object to stack by creating a node with data 
	 * and adds it as tail of list. Special case if first
	 * item by setting node as head & tail of list
	 * }
	 * 
	 * @param value Object being added to stack
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void push(T element) {
		if(currentSize == maxSize)
			throw new IllegalStateException();
		else {
			Node node = new Node(element);
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
	 * Returns and removes data of last in stack
	 * }
	 * 
	 * @return Data of last in stack
	 */
	@SuppressWarnings("unchecked")
	public T pop() {
		T item = (T) last.data;
		this.last = last.prev;
		currentSize--;
		return item;
	}
	
	/**
	 * {@summary
	 * Shows data of last in stack, but does not remove from stack
	 * }
	 * 
	 * @return Data of last in stack
	 */
	@SuppressWarnings("unchecked")
	public T peek() {
		return (T) last.data;
	}
	
	/**
	 * {@summary
	 * Getter method to return the current size of the stack
	 * }
	 * 
	 * @return Current size of the stack
	 */
	public int currentSize() {
		return currentSize;
	}
	
	/**
	 * {@summary
	 * Checks if stack is empty by looking at current size value
	 * }
	 * 
	 * @return True if current size is empty
	 */
	public boolean isEmpty() {
		if(currentSize == 0)
			return true;
		else
			return false;
	}
	
	/**
	 * {@summary
	 * Checks if stack is full by comparing current and max value
	 * }
	 * 
	 * @return True if current and max size are equal
	 */
	public boolean isFull() {
		if(currentSize == maxSize)
			return true;
		else
			return false;
	}
	
}

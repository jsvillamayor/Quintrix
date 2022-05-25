
public class Node<T> {

	@SuppressWarnings("rawtypes")
	Node next, prev;
	T data;
	
	/**
	 * {@summary
	 * Default constructor
	 * }
	 */
	public Node() {
		
	}
	
	/**
	 * {@summary
	 * Constructor if Node what to by instantiated with data
	 * }
	 * @param data
	 */
	@SuppressWarnings("unchecked")
	public Node(Object data) {
		this.data = (T) data;
	}
	
}

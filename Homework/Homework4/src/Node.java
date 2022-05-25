
/**
 * {@summary
 * Node class that points to next and previous nodes and also holds data
 * }
 * @author James
 *
 * @param <T>
 */
public class Node<T> {

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
	public Node(Object data) {
		this.data = (T) data;
	}
	
}

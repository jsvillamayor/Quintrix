
/**
 * 
 * @author James
 * 
 *{@summary Homework 4 where we build the LinkedList class from scratch.}	
 *
 * @param <T>
 */
public class LinkedList<T> {

	private Node head, tail;
	private int size;
	
	/**
	 * {@summary
	 * This is the default constructor for LinkedList
	 * When initializing a LinkedList, we default size to 0
	 * }
	 */
	public LinkedList() {
		this.size = 0;
	}
	
	/**
	 * {@summary
	 * By default, when adding, we assume user wants to
	 * add to the end of the list, so we call addLast method.
	 * 
	 * We also have a special case if it is first item 
	 * in the list, we call addFirst method
	 * }
	 * @param item
	 */
	public void add(Node item) {
		if(size == 0)
			addFirst(item);
		else
			addLast(item);
	}
	
	/**
	 * {@summary
	 * We add node at index given by the user.
	 * }
	 * 
	 * @param item	
	 * @param index where we want to add node in list
	 */
	public void add(Node item, int index) {
		if(index < 0 || index > size)
			throw new IndexOutOfBoundsException();
		if(index == size)
			addLast(item);
		else {
			item.next = head;
			for(int i = 0; i < index; i++) {
				item.prev = item.next;
				item.next = item.next.next;
			}
			item.prev.next = item;
			item.next.prev = item;
			size++;
		}
	}
	
	/**
	 * {@summary
	 * Adding node at the beginning of List
	 * }
	 * @param item
	 */
	public void addFirst(Node item) {
		if(size == 0) {
			this.tail = item;
		}
		else {
			item.next = head;
			item.next.prev = item;
		}
		this.head = item;
		size++;
	}
	
	/**
	 * {@summary
	 * Adding node at the end of List
	 * }
	 * 
	 * @param item
	 */
	public void addLast(Node item) {
		if(size == 0) {
			addFirst(item);
		}
		else {
			item.prev = tail;
			item.prev.next = item;
			this.tail = item;
			size++;
		}
	}
	
	/**
	 * {@summary
	 * Clearing the list of all nodes and setting size to 0
	 * }
	 */
	public void clear() {
		this.head = null;
		this.tail = null;
		size = 0;
	}
	
	/**
	 * {@summary
	 * Searches through List and checks if item is in List
	 * }
	 * @param item 
	 * @return if item is in list
	 */
	public boolean contains(Object item) {
		Node temp = new Node();
		temp.next = head;
		for(int i = 0; i < size; i++) {
			if(temp.next.data.equals(item))
				return true;
			temp.next = temp.next.next;
		}
		return false;
	}
	
	/**
	 * {@summary
	 * Works similarly like contains() method
	 * but instead of boolean, returns index if item is found
	 * }
	 * @param item
	 * @return
	 */
	public int indexOf(Object item) {
		Node temp = new Node();
		temp.next = head;
		for(int i = 0; i < size; i++) {
			if(temp.next.data.equals(item))
				return i;
		}
		return -1;
	}
	
	/**
	 * {@summary
	 * Returns value of whatever is in List at specified index
	 * }
	 * @param index
	 * @return
	 */
	public T get(int index) {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node temp = new Node();
		temp.next = head;
		for(int i = 0; i <= index; i++) {
			temp.prev = temp.next;
			temp.next = temp.next.next;
		}
		return (T) temp.prev.data;
		
	}
	
	/**
	 * {@summary
	 * Returns data of first node
	 * }
	 * @return
	 */
	public T getFirst() {
		return (T) head.data;
	}
	
	/**
	 * {@summary
	 * Returns data of last node
	 * }
	 * @return
	 */
	public T getLast() {
		return (T) tail.data;
	}
	
	/**
	 * {@summary
	 * Removes all instances of item in List
	 * }
	 * @param item
	 */
	public void remove(Object item) {
		Node temp = new Node();
		temp.next = head;
		for(int i = 0; i < size; i++) {
			if(temp.next.data.equals(item)) {
				temp.next.prev.next = temp.next.next;
				temp.next.next.prev = temp.next;
			}
			else {
				temp.next = temp.next.next;
			}
		}
	}
	
	/**
	 * {@summary
	 * Removes item in List of specified index
	 * }
	 * @param index
	 */
	public void remove(int index) {
		if(index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
		Node temp = new Node();
		temp.next = head;
		for(int i = 0; i < index; i++) {
			temp.next = temp.next.next;
		}
		temp.next.prev.next = temp.next.next;
		temp.next.next.prev = temp.next.prev;
	}
	
	/**
	 * {@summary
	 * Removes first node in List
	 * }
	 */
	public void removeFirst() {
		this.head = head.next;
		this.head.prev = null;
	}
	
	/**
	 * {@summary
	 * Removes last node in List
	 * }
	 */
	public void removeLast() {
		this.tail = tail.prev;
		this.tail.next = null;
	}
	
	/**
	 * {@summary
	 * Checks if List is empty by looking at size
	 * }
	 * @return if List is empty
	 */
	public boolean isEmpty() {
		if(size == 0)
			return true;
		return false;
	}
	
	
}



import java.util.Iterator;


public class LinkedListB<T> implements Iterable<T> {
	private Node head;
	
	/**
	 * creates a linked list
	 */
	public LinkedListB() {
		head = null;
	}
	
	/**
	 * adds node to the linked list
	 * @param value T value of the node
	 */
	public void add(T value) {
		Node newNode = new Node(value);
		if(head == null) {
			head = newNode;
			return;
		}
		Node current = head;
		while(current.next != null) {
			current = current.next;
		}
		current.next = newNode;
	}
	
	/**
	 * adds node on the specific index in the linked list
	 * @param value T value of the node
	 * @param index int index of the place in the list
	 */
	public void add(T value, int index) {
		if (index < 0 || index > getSize())
			throw new IndexOutOfBoundsException("...");
		Node newNode = new Node(value);
		if (index == 0) {
			head = newNode;
			return;
		}
		Node current = head.next;
		Node previous = head;
		int counter = 1;
		while (counter < index) {
			current = current.next;
			previous = previous.next;
			counter++;
		}
		previous.next = newNode;
		newNode.next = current;		
	}
	
	/**
	 * removes specific node from the linked list
	 * @param index int index of the place in the list
	 */
	public void removeAt(int index) {
		if (index < 0 || index >= getSize())
			throw new IndexOutOfBoundsException("...");
		Node current = head;
		if(index == 0) {
			head = head.next;
			current = null;
			return;
		}
		current = head.next;
		Node previous = head;
		int counter = 1;
		while(counter < index) {
			current = current.next;
			previous = previous.next;
			counter++;
		}
		previous.next = current.next;
		current.next = null;
	}
	
	/**
	 * gets the size of the linked list
	 * @return size
	 */
	public int getSize() {
		int size = 0;
		Node current = head;
		while(current != null) {
			current = current.next;
			size++;
		}
		return size;
	}
	
	/**
	 * gets the value of the specific node in the linked list
	 * @param index int index of the place in the list
	 * @return value
	 */
	public T getAt(int index) {
		if (index < 0 || index > getSize())
			throw new IndexOutOfBoundsException("...");
		if(index == 0) {
			return (T)head.value;
		}
		Node current = head;
		int counter = 1;
		while(counter <= index) {
			current = current.next;
			counter++;
		}
		return (T)current.value;
	}
	
	public String toString() {
		Node current = head;
		String str = "";
		str += "[ ";
		while(current != null) {
			str += current.value;
			if(current.next != null) {
				str += ", ";
			}
			current = current.next;
		}
		str += " ]";
		return str;
	}
	
	private class Node<T> {
		public T value;
		public Node next;
		
		/**
		 * creates node
		 * @param value T value of the node
		 */
		public Node(T value) {
			this.value = value;
			next = null;
		}
	}

	@Override
	public Iterator<T> iterator() {
		return new Biterator<T>(head);
	}
	
	private class Biterator<T> implements Iterator<T>{
		private Node<T> current;
		
		public Biterator(Node start){
			current = start;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}
		
		@Override
		public T next() {
			T value = current.value;
			current = current.next;
			return value;
		}
		
	}

}

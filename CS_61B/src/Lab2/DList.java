/**
 * 
 */
package Lab2;

/**
 * @author Huseen Sufi
 * Doubly Linked List implementation using  sentinel header/trailer nodes
 * accepts generic objects
 */
public class DList <T>{
	//empty sentinel Nodes that always point to first/last nodes 
	private DListNode header; //head sentinel
	private DListNode trailer; //tail sentinel
	private int size = 0; //size of node
		
	 //
		/**
		 * Nested inner DListNode class
		 * @author Huseen Sufi
		 *
		 */
		public class DListNode {
			private DListNode next; //next pointer
			private DListNode prev; //prev pointer 
			private T item; // generic Object
			
			/**
			 * Defualt  Constructor
			 * @param next
			 * @param prev
			 * @param item
			 */
			public DListNode(DListNode next, DListNode prev, T item) {
				this.next = next;
				this.prev = prev;
				this.item = item;
			}
			
			//getters
			public T getItem() {
				return item;
			}
			public DListNode getNext() {
				return next;
			}
			public DListNode getPrev() {
				return prev;
			}
			//setters
			public void setNext(DListNode next) {
				this.next = next;
			}
			public void setPrev(DListNode prev) {
				this.prev = prev;
			}
			public void setItem(T item) {
				this.item = item;
			}
		
		} //end DListNode class
	
	//
	/**
	 * D List Default Constructor
	 */
	public DList() {
		size = 0;
		header = new DListNode(null, null, null); //empty header
		trailer = new DListNode(null, null, null); //empty trailer
		header.setNext(trailer); //make header point to trailer
		trailer.setPrev(header);
	}
	/**
	 * @return size of list
	 */
	public int size() {
		System.out.println(size);
		return this.size;
	}
	
	/**
	 * @return true/false whether list is empty or not
	 */
	public boolean isEmpty() {
		return size == 0; // if true list is empty
	}
	
	/**
	 * @return head node in constant time
	 * @throws IllegalStateException
	 */
	public T getFirst() throws IllegalStateException {
		if (isEmpty()) throw new IllegalStateException("Error List Is Empty");
			return header.getNext().getItem(); //return sentinel next
		}
	
	/**
	 * @return last item item in list
	 * @throws IllegalStateException
	 */
	public T  getLast() throws IllegalStateException {
		if (isEmpty()) throw new IllegalStateException("Error List is Empty"); 
			return trailer.getPrev().getItem();
		}
	
	public T getItem(int index) {
		DListNode current = getNode(index);
		return current.getItem();
	}
	
	/**
	 * @param index
	 * @return node at specified index
	 */
	private DListNode getNode(int index) {
		int count = 0;
		
		//list empty or element past bounds
		if (index < 0  ||  (size <= 0 ||  index > size-1)) {
			return null;
		}
		
		//always an item in list
		DListNode current = header.next;
		while (current.getNext() != null && count < index) {
			current = current.getNext();
			count++;
		}
		return current;
	}
	

	/**
	 * add Node at Specified index
	 * @param index
	 * @param toAdd
	 * @return T
	 */
	public T addNode(int index, T toAdd) {
		DListNode toAddNode = new DListNode(null, null, toAdd);
	
		//if list is empty
		DListNode current = getNode(index);
		if((getNode(index) == null) && (size == 0)) {
			toAddNode.setNext(trailer);
			trailer.setPrev(toAddNode);
			toAddNode.setPrev(header);
			header.setNext(toAddNode);
			size++;
			return toAddNode.getItem();
			//if list index 1
		}  else if(index == size ) {
			DListNode prev = trailer.getPrev();
			prev.setNext(toAddNode);
			toAddNode.setPrev(prev);
			toAddNode.setNext(trailer);
			trailer.setPrev(toAddNode);
			size++;
			return toAddNode.getItem();
		} else {
			DListNode prev = current.getPrev();
			
			//add node at index
			current.setPrev(toAddNode);
			prev.setNext(toAddNode);
			toAddNode.setPrev(prev);
			toAddNode.setNext(current);
			this.size++;
			return toAddNode.getItem();
		}
	}
		
	
	
	/**
	 * removes Node at specified index
	 * @param index
	 * @return T
	 */
	public T removeNode(int index) {
		DListNode toDelete = getNode(index);
		if (toDelete == null) {
			System.out.println("Error can't delete null item");
			return null;
		} else {
			DListNode prev = toDelete.getPrev();
			DListNode next = toDelete.getNext();
			
			//unLink Node at specific index
			prev.setNext(next);
			next.setPrev(prev);
			toDelete.setNext(null);
			toDelete.setPrev(null);
			this.size--;
			return toDelete.getItem();
		}
	}
		/**
		 * @param t
		 * @return remove first occurrence of object in list
		 */
		public T removeObject(T t) { //TODO remove first occurrence of object
			return t;
		}
		
	/* print out List by:
	 * iterate over the list 
	 * append each object  in list to StringBuilder object
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Items in Linked List: [ ");
		
		DListNode current = header.getNext();
		while (current.getNext() != null) {
			sb.append(current.getItem());
			sb.append(", ");
			current = current.getNext(); //increment
		}
		sb.append("  ]");
		String listItems = sb.toString();
		return listItems;
	}
} //end DList Class
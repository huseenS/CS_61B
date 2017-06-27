package Homework2;

/*Linked List with private sentinel node that  acts as dummy head pointer (points to null)  so that list is never empty . */

public class SList<T> {
	//private sentinel
	private Node sentinel;
	public int size = 0;
	
	
	//inner node class
	public class Node {
		public T item;     /* Equivalent of first */
		public Node next; /* Equivalent of rest */

	
		//node constructor 
		public Node(T item, Node next) {
			this.item = item;
			this.next = next;		
		}
	} 

	/** Empty Constructor. */
	public SList() {
		size = 0;
		sentinel = new Node(null, null);
	}

	/* Construct  list with one item */
	public SList(T x) {
		size = 0;
		sentinel = new Node(null, null);
		//dummy header next points to new node
		sentinel.next = new Node(x, null);
	}

	/** Adds an item of the front. */
	public void insertFront(T x) {
		Node oldFrontNode = sentinel.next;
		//create new node that points to old front
		Node newNode = new Node(x, oldFrontNode);
		//dummy header now points to new node
		sentinel.next = newNode;
		//increase size
		size++;
		System.out.println("inserted node " + getFront() + " at front of list");
	}

	/** Gets the front item of the list. */
	public T getFront() {
		return sentinel.next.item;
	}

	/** Puts an item at the back of the list. */
	public void insertBack(T x) {
		//save sentinel in temp node
		Node current = sentinel;
		
		//get the back node
		current = getBackNode();
		//temp's next is now a new node that points to null--end of list
		current.next = new Node(x, null);
		size++;
	
		System.out.println("inserted node " + getBack() + " at back of list");

	}

	/** Returns the node at the end of the list. */
	public Node getBackNode() {
		//save sentinel in temp
		Node current = sentinel;

		/* Move sentinel pointer until it reaches the end. */
		while (current.next != null) {
			current =current.next;
		}
		return current;
	}

	/** Returns last item */
	public T getBack() {
		//call method to retrieve node at end of list
		Node back = getBackNode();
		//return that nodes object
		return back.item;
	}

	/** Returns size of the list*/
	public int size() {
		System.out.println("size of list is: " + size);
		return size;
	}
	
	//delete a node happen
	public T deleteNodeAt(int index){
		if (index > size-1) {
			//index is too large
			return null;
		}
		
		int count = 0;
		Node current = sentinel;
		Node previous = current; 
		while (current.next != null && count != index) {		
			//shifting both forward
			previous = current;
			current = current.next;
		}
		//delete element
		System.out.println("Going to delete node: " + current.item + " at index:  " + index);
		previous.next = current.next;
		current.next = null;
		size--;

		//return deleted item
		return current.item;

	}
	
	@Override
	public String toString() {
		
		Node current = sentinel;
		StringBuilder listOfNodes = new StringBuilder();
		//iterate over list nodes and add each item to list
		while (current.next != null) {
			listOfNodes.append(current.item).append("  ");
			current = current.next;
		}
		
		return listOfNodes.toString();
	}
	
}
	

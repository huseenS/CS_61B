package lists;

public class SingleLinkedList<T> implements IList<T> {
	private ISLinkNode<T> sentinel, trailer;
	private int size = 0;


	/**
	 * 
	 * @param toInsert
	 * @param size
	 */
	public SingleLinkedList(ISLinkNode<T> toInsert, int size) {
		this.size = 1;
		this.sentinel = new ISLinkNode<>(null, toInsert);
		this.trailer = new ISLinkNode<>(null, toInsert);
		
	}
	/**
	 * 
	 */
	public SingleLinkedList() {
		this.size = 0;
		this.sentinel = new ISLinkNode<>(null, trailer);
		this.trailer = new ISLinkNode<>(null, sentinel);
	}

	@Override
	/**
	 * General insert which checks if inserting at head, tail or elsewhere
	 */
	public void insert(int idx, T v) {
		ISLinkNode<T> prev = null;
		ISLinkNode<T> current = sentinel;
		ISLinkNode<T> toInsert = new ISLinkNode<>(v, null);
		int temp = 0;
		//check if head points to trailer---empty list {
		//loops through until one before index to insert
		while(current != null && temp != idx) {
			prev = current;
			current = (ISLinkNode<T>) current.getNext();
			temp++;
			//insert head
			if(idx == 0) {
				ISLinkNode<T> oldfront = (ISLinkNode<T>) sentinel.getNext();
				toInsert.setNext(oldfront);
				sentinel.setNext(toInsert);
				size++;
				//insert tail
			} else if(current.getNext() == null && idx > temp + 1) {
				current.setNext(toInsert);
				trailer.setNext(toInsert);
			//insert in middle
			} else {
				prev.setNext(toInsert);
				toInsert.setNext(current);
			}
		}
		//else add one node
		//}
		size++;
		System.out.println("inserted node at " + idx);
	}

	@Override
	/**
	 * Adds an item to the end of list. Called 'Add' in class, but more usually called 
	 * append in other libraries. Moves <i>current</i> to the end of the list.
	 * @param v Item to add
	 */
	public void append(T v) {
		// TODO Auto-generated method stub
		
	}

	@Override

	/**
	 * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes 
	 * the previous item in the list, if such element exists.
	 */
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	/**
	 * Removes the item at a specific index
	 * @param idx index of item to remove
	 */
	public void remove(int idx) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	/**
	 * Fetches the value at the <i>current</i> index in the list.
	 * @return the requested item
	 */
	public void move(int sidx, int didx) {
		// TODO Auto-generated method stub
		
	}

	@Override

	/**
	 * Fetches the value at a specific index in the list.
	 * @param idx index of the item to return
	 * @return the requested item
	 */
	public T fetch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T fetch(int idx) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		sentinel.setNext(sentinel.getNext());
	}

	@Override
	public void prev() {
		ISLinkNode<T> current = (ISLinkNode<T>) sentinel.getNext();
		ISLinkNode<T> previous = current;
		while(sentinel.getNext() != null); {
			previous = current;
			current = (ISLinkNode<T>) current.getNext();
		}
		
	}

	@Override
	public void jumpToTail() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void jumpToHead() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		
		ISLinkNode<T> current = sentinel;
		StringBuilder listOfNodes = new StringBuilder();
		//iterate over list nodes and add each item to list
		while (current.getNext() != null) {
			listOfNodes.append(current.getValue()).append("  ");
			current = (ISLinkNode<T>) current.getNext();
		}
		
		return listOfNodes.toString();
	}

}

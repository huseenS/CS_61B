package lists;

public class ISLinkNode<T> implements ISLink<T> {
	private T item;
	private ISLinkNode<T> next;
	
	
	//node constructor
	public ISLinkNode(T item, ISLinkNode<T> next) {
		this.item = item;
		this.next = next;
	}
	
	@Override
	public T getValue() {
		return this.item;
	}

	@Override
	public void setValue(T v) {
		this.item = v; 
	}

	@Override
	public ISLink<T> getNext() {
		return this.next;
	}

	@Override
	public void setNext(ISLink<T> c) {
		next = (ISLinkNode<T>) c;
	}
	
}

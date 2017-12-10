package BTree;

public class Dict<K extends Comparable<K>,V> implements IDict<K,V> {
	//array of keys
	private DoubleLinkList<KeyValuePair> Dlist;
	private int size;
	
	/*
	 * 
	 */
	public Dict() {
		this.Dlist = new DoubleLinkList<>();
		this.size = 0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public V add(K k, V v) {
		KeyValuePair<K, V> kv = new KeyValuePair(k,v);
		while(Dlist.size() !=  )
		Dlist.append(kv);
		Dlist.jumpToTail();
		return (V) Dlist.curr;
	}

	@Override  bbvb
	public V remove(K k) {
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public V fetch(K k) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public K[] keys() {
		// TODO Auto-generated method stub
		return null;
	}

}

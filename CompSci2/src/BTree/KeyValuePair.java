package BTree;


public class KeyValuePair<K extends Comparable<K>, V>{
  private K key;
  private Object value;

  /**
   * @param K the key of the new Entry
   * @param V the value to store in the new Entry
   */
  public KeyValuePair(K t, V p){
    key = t;
    value = p;
  }

  /**
   * @return the key of the Entry
   */
  public K getKey(){ return key; }

  /**
   * @return the value stored in the Entry
   */
  public Object getValue(){ return value; }

  /**
   * @param K the new value to be stored
   */
  public void setValue(V s){ value = s; }

}
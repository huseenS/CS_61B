package BTree;
public class Node<K extends Comparable<K>,T> {
    K key;
    T value;
    Node left;
    Node right;

    /**
     * Makes a shiny new Node
     * @param k the key
     * @param v the value
     */
    public Node(int k, T v) {
        key = k;
        value = v;
    }

    /**
     * Sets the left child of this node
     * @param l the new left child
     */
    public void setLeft(Node<T> l) {
        left = l;
    }

    /**
     * Sets the right child of this node
     * @param r the new left child
     */
    public void setRight(Node<T> r) {
        right = r;
    }

    /**
     * Gets the left child
     * @return left child
     */
    public Node<T> getLeft() {
        return left;
    }
    /**
     * Gets the right child
     * @return right child
     */
    public Node<T> getRight() {
        return right;
    }

    /**
     * Checks if the node is a leaf
     * @return true if the node is a leaf
     */
    public boolean isLeaf() {
        if(left==null && right==null) {
            return true;
        }
        return false;
    }

    /**
     * Gets the key for this node
     * @return the key value
     */
    public int getKey() {
        return key;
    }

    /**
     * Gets the value for this node
     * @return the node value
     */
    public T getValue() {
        return value;
    }
}

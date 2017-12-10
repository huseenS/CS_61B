package BTree;

public class Tree<T> {
    Node<T> root;
    Node<T> curr;

    /**
     * Makes a new empty tree
     */
    public Tree() {
        root = null;
        curr = null;
    }

    /**
     * Places a new node in the tree
     * @param k key for the new node
     * @param v value for new node
     */
    public void insert(int k, T v) {
        // look at the root first
        curr = root;
        if(curr==null) {
            root=new Node<T>(k,v);
            return;
        }
        // What to do if we aren't inserting the root
        helper(k,v);
    }
    // Helps with the insertion method
    public void helper(int k, T v) {
        // Does the new node fit as a direct child
        if((k<curr.getKey() && curr.getLeft()==null) || (k>curr.getKey() && curr.getRight()==null) ){
            if(k<curr.getKey()) {
                // insert left
                curr.setLeft(new Node<T>(k,v)); 
            } else {
                // insert right
                curr.setRight(new Node<T>(k,v)); 
            }
            // Work done for the easy case
            return;
        }
        // Place the node with one of the children, based on if the key
        // goes to the left or the right
        if(k<curr.getKey()) {
            curr = curr.getLeft();
        } else {
            curr = curr.getRight();
        }
        helper(k,v);
    }

    /**
     * Get the value associated with some key
     * @param k key to search for in the tree
     * @return value associated with the key
     */
    public T fetch(int k) {
        // start at the root
        curr = root;
        // while we haven't found the key
        while(curr.getKey()!=k) {
            if(k > curr.getKey()) {
                // walk right
                curr = curr.getRight();
            } else {
                // walk left
                curr = curr.getLeft();
            }
        }
        // We have found the key or ran out of children
        return curr.getValue();
    }

    /**
     * Removes a node from the tree based on the key
     * @param k the key to remove
     */
    public void remove(int k) {
        // Find the node to remove and it's parent
        Node<T> parent = null;
        // start at the root
        curr = root;
        // while we haven't found the key
        while(curr.getKey()!=k) {
            if(k > curr.getKey()) {
                // walk right
                parent = curr;
                curr = curr.getRight();
            } else {
                // walk left
                parent = curr;
                curr = curr.getLeft();
            }
        }
        // We have the node and it's parent

        // Case 1: no children, just kill the node
        // ...could have used isLeaf... but didn't think of that first
        if(curr.getRight()==null && curr.getLeft()==null) {
            if(parent.getRight()==curr) { parent.setRight(null); }
            if(parent.getLeft()==curr)  { parent.setLeft(null); }
            curr = root;
            return;
        }
        // Case 2: 1 child, replace node with child
        // ...maybe redundant... might remove later
        if(curr.getRight()==null || curr.getLeft()==null) {
            // Set the parent to point at the child
            if(curr.getRight()==null) {
                if(parent.getRight()==curr) {
                    parent.setRight(curr.getLeft());
                } else {
                    parent.setLeft(curr.getLeft());
                }
            } else {
                // if(curr.getLeft()==null)
                if(parent.getRight()==curr) {
                    parent.setRight(curr.getRight());
                } else {
                    parent.setLeft(curr.getRight());
                }
            }
            curr=root;
            return;
        }
        // Case 3: Go right once, go left until you can't, remove that 
        //         left most node, replace the node you wanted to remove
        //         with the left most node
        // Does this work if the curr is the root... Probably not
        Node<T> swapparent = curr;
        Node<T> swapnode = curr.getRight(); // trying to find the one to swap
                                            // into curr's place in the tree
        while(swapnode.getLeft() != null) {
            swapparent=swapnode;
            swapnode=swapnode.getLeft();
        }
        // Have left most node, set the left most parent to the right child
        swapparent.setLeft(swapnode.getRight());
        swapnode.setLeft(curr.getLeft());
        swapnode.setRight(curr.getRight());
        if(parent.getRight()==curr) { parent.setRight(swapnode); }
        if(parent.getLeft()==curr)  { parent.setLeft(swapnode); }
        curr = root;
    }

    /**
     * Main method to do some basic checks on functionality
     */
    public static void main(String[] argv) {
        Tree t = new Tree<Integer>();
        t.insert(17,17);
        t.insert(20,20);
        t.insert(25,25);
        t.insert(18,18);
        t.insert(1,1);
        t.insert(21,21);
        t.insert(22,22);
        t.remove(20);
        System.out.println(t.fetch(22));
        System.out.println(t.fetch(20));
    }
}

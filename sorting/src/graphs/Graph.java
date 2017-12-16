package graphs;

public class Graph<T> {
    IList<Node<T>> nodes; // maybe?
    IList<Edge<T,W>> edges; // maybe?
    Node<T> curr; // current node in the graph?

    public Graph() {
        nodes = new DoubleLinkList<>();
        edges = new DoubleLinkList<>();
        curr  = null;
    }

    /**
     * Insert a new node
     * @param v value for the new node
     * @return encouraging message
     */
    public String insertNode(T v) {
        Node<T> n = new Node<>(v);
        curr = n;
        nodes.append(n);

        // return the message
        return "Great job!!";
    }

    /**
     * Insert a new edge between a and b
     * @param a Node A
     * @param b Node B
     * @param w weight of the edge
     */
    public void insertEdge(Node<T> a, Node<T> b, int w) {
        Edge<T,W n = new Edge<T,W>(a,b,w);
        edges.append(n);
        // Book keeping for when nodes know their edges
        //a.addEdge(n);
        //b.addEdge(n);
    }

    /**
     * Retrieve the node with a specific value
     * @param v the value
     * @return the node
     */
    public Node<T> fetchNode(T v) {
        for(int i=0;i<nodes.size(); i++) {
            Node<T> n = nodes.fetch(i);
            if( n.getValue().equals(v) ) {
                return n;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Graph<String> g = new Graph<>();
        g.insertNode("Hi");
        g.insertNode("Howdy");
        System.out.println(g.fetchNode("Hi"));
        System.out.println(g.fetchNode("Bye bye"));
    }
}

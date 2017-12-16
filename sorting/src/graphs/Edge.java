package graphs;

public class Edge<N,W> implements IEdge<N, W> {
	private INode<N> a;
	private INode<N> b;
	W w;
    
	// Implementors should implement a construct that takes in the 
    // source, destination, and weight
	public Edge(INode<N> a, INode<N> b, W weight) {
		this.a = a;
		this.b = b;
		this.w = weight;
	}
	
	/**
     * The source node of the edge
     * @return the source node
     */
	@Override
	public INode<N> getSource() {
		return this.a;
	}

	/**
     * The destination node of the edge
     * @return the destination node
     */
	@Override
	public INode<N> getDestination() {
		return this.b;
	}

	 
	@Override
	public W getWeight() {
		return this.w;
	}
	
	/**
     * Test for equality of two edges.
     * Edges are equal when the node instances are exactly the same; i.e. this.src==o.src
     * and this.dst == o.dst
     * @param o the other edge
     * @return true if the edges are the same
     */
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		Edge<N,W> other = (Edge<N,W>) obj;
		if (this.a == other.getSource() && this.b == other.getDestination()) {
			return true;
		} else {
			return false;
		}
	}
	
	
}

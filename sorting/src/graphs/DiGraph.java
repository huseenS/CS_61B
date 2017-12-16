package graphs;

public class DiGraph<N,W> implements IGraph<N, W> {
	DoubleLinkList<INode<N>> nodes;
	DoubleLinkList<IEdge<N,W>> edges;
	INode<N> current;
	
	/*
	 *  @param nodes, list of nodes
	 *  @param edges, list of edges
	 *  @param current, current node
	 */
	public DiGraph() {
		this.nodes = new DoubleLinkList<>();
		this.edges = new DoubleLinkList<>();
		this.current = null;
	}
	 /**
     * Adds a node to the graph
     * @param v value at the node
     * @return the newly added node
     */
	@Override
	public INode<N> addNode(N v) {
		Node<N> toAdd = new Node<>(v);
		nodes.append(toAdd);
		current = toAdd;
		return toAdd;
	}
	
	/**
     * Adds an edge to the graph.
     * Duplicate edges are not allowed in the graph. The equals method of the edge can
     * be used to determine if two edges duplicate one another.
     * @param w weight of the edge
     * @param s source node
     * @param d destination node
     */
	@Override
	public void addEdge(INode<N> s, INode<N> d, W w) {
		Edge<N,W> toAdd = new Edge<>(s, d, w);
		
		for (int i = 0; i < edges.size(); i++) {
			if (!edges.fetch().equals(toAdd)) {
				edges.append(toAdd);
			} else {
				System.out.println("Sorry can't add duplicate edge");
			}
		}
		
	}
	
	@SuppressWarnings("unchecked")
	private INode<N>[] nodeListToArray(DoubleLinkList<INode<N>> neighbors) {
		neighbors.jumpToHead();
		INode<N>[] toReturn = new INode[neighbors.size()];
		for(int i = 0; i < neighbors.size(); i++) {
			toReturn[i] = neighbors.fetch(); 
			neighbors.next();
		}
		return toReturn;
	}
	@SuppressWarnings("unchecked")
	private IEdge<N,W>[] edgeListToArray(DoubleLinkList<IEdge<N,W>> list) {
		list.jumpToHead();
		IEdge<N,W>[] toReturn = new IEdge[list.size()];
		for(int i = 0; i < list.size(); i++) {
			toReturn[i] = list.fetch(); 
			list.next();
		}
		return toReturn;
	}

	/**
     * Gets an array of all the nodes in the graph
     * @return the node set
     */
	@Override
	public INode<N>[] getNodeSet() {
		return nodeListToArray(nodes);
	}
	
	/**
	* Gets an array of all the edges in the graph
	* @return the edge set
	*/
	@Override
	public IEdge<N, W>[] getEdgeSet() {
		return edgeListToArray(edges);
	}
	
	/**
     * An array of the neighbors of a node
     * @param n the node
     * @return neighbors of n
     */
	@Override
	public INode<N>[] getNeighbors(INode<N> n) {
		DoubleLinkList<INode<N>> neighbors = new DoubleLinkList<>();
		edges.jumpToHead();
		
		for (int i = 0; i < edges.size(); i++) {
			IEdge<N, W> current = edges.fetch();
			//check if current edge source equals this node
			if (current.getSource() == n) {
				//add current edge's destination to neighbors list
				neighbors.append(current.getDestination());
				//check if current edge destination equals this node
			} else if(current.getDestination() == n) {
				//add current edge's source to neighbor list
				neighbors.append(current.getSource());
			}
			edges.next();
		}
		return nodeListToArray(neighbors);
		
	}

	/**
  * Gets an array of all the edges sourced at a particular node
  * @param n the source node
  * @return the edge set
  */
	@Override
	public IEdge<N, W>[] getEdgesFrom(INode<N> n) {
		DoubleLinkList<IEdge<N, W>> sourceEdges = new DoubleLinkList<>();
		edges.jumpToHead();
		for (int i = 0; i < edges.size(); i++) {
			IEdge<N, W> current = edges.fetch();
			if (current.getSource().equals(n)) {
				sourceEdges.append(current);
			}
			edges.next();
		}
		return edgeListToArray(sourceEdges);
		
	}

	@Override
	/**
  * Gets an array of all the edges destined for a particular node
  * @param n the destination node
  * @return the edge set
  */
	public IEdge<N, W>[] getEdgesTo(INode<N> n) {
		DoubleLinkList<IEdge<N,W>> destEdges = new DoubleLinkList<>();
		edges.jumpToHead();
		for (int i = 0; i < edges.size(); i++) {
			IEdge<N, W> current = edges.fetch();
			if (current.getDestination().equals(n)) {
				destEdges.append(current);
			}
			edges.next();
		}
		return edgeListToArray(destEdges);
	}
}

package graphs;

public class Node<N> implements INode<N> {
	private N value;
	
	// Implementors should provide a constructor that takes in a single argument, the
    // value for the node to initially hold. Nodes may have their values changed
	public Node(N value) {
		this.value = value;
	}

	
	@Override
	public void setValue(N v) {
		this.value = v;
	}

	@Override
	public N getValue() {
		return this.value;
	}

}

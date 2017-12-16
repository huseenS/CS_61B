package graphs;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.PatternSyntaxException;

/**
 * Class that is capable of reading in a graph file from disk.
 * Graph files are line based. Node names have type String and edge weights have 
 * type Double. Fields on the line are separated by ':' and there is no extra white space.
 */
public class DiGraphReader implements IGraphReader {
    // Fields needed for the Graph Reader should be added here
    
    /**
     * Creates a new graph reader instance
     */
    public DiGraphReader() {
        // Configure the graph reader here
    	
    }
    
    /**
     * Reads in a file and instantiates the graph
     * @param filename the file to read
     * @return the instantiated graph
     */
    @Override
	public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException {
    	boolean isNodeA = false, isNodeB = false;
    	INode<String> nodeA = null, nodeB = null;
    	DiGraph<String,Double> graph = new DiGraph<>();
    	
        // Open the file
    	try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
    		 // Parse the lines. If a line does not have exactly 3 fields, ignore the line
    		String l = br.readLine();
    		while(l != null ) {
    			try {
    				String[] lines = null;
            		lines = l.split(":");
            		Double weight = Double.parseDouble(lines[2]); //weight is third item
            		 //check node matches
            		graph.nodes.jumpToHead();
            		String check = graph.nodes.fetch().getValue();
            		while(graph.nodes.fetch() != graph.nodes.tail) {
            			//check matches
            			if(check.equals(lines[0])) {
            				//grab node already in list
            				isNodeA = true;
            				nodeA = graph.nodes.fetch();
            			} else if(check.equals(lines[1])) {
            				isNodeB = true;
            				nodeB = graph.nodes.fetch();
            			} else {
            				isNodeB = false;
            				isNodeA = false;
            			}
            			graph.nodes.next(); //move to next node in list
            			//add edges/nodes to graph
            			if(isNodeA && isNodeB) { //check if both nodes are already in the list
            				graph.addEdge(graph.addNode(nodeA.getValue()), graph.addNode(nodeB.getValue()), weight);
            			} else if(!isNodeA && !isNodeB) { //neither in the list
            				graph.addEdge(graph.addNode(lines[0]), graph.addNode(lines[1]), weight);
            			} else if(!isNodeA && isNodeB) { //nodeA not in List
            				graph.addEdge(graph.addNode(lines[0]), nodeB, weight);
            			} else if(isNodeA && !isNodeB) { //nodeB not in the list
            				graph.addEdge(nodeA, graph.addNode(lines[1]), weight);
            			}
            			
            			l = br.readLine();
            		}
    			} catch (PatternSyntaxException p) {
    	    		System.err.println("Didn't read line");
    			} 
    		} 
    	}
       

        // Return the graph instance
        return graph;
    }
    
    /**
     * Simple main method to open and process a file
     */
    public static void main(String[] argv) throws Exception {
        // This code should work without modification once your reader code is working
        IGraphReader r = new DiGraphReader();
        IGraph<String,Double> g = r.read("graphfile.cs2");
        IEdge<String,Double>[] edges = g.getEdgeSet();
        for(int i=0; i<edges.length; i++) {
            System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
        }
    }
}
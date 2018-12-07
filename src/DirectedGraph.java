import java.util.ArrayList;

public class DirectedGraph {

    private final int numNodes;

    private final ArrayList<Edge>[] adjacencyLists;

    @SuppressWarnings("unchecked")
    public DirectedGraph(int numNodes) {

        this.numNodes       = numNodes;
        this.adjacencyLists = (ArrayList<Edge>[]) new ArrayList<?>[numNodes];

        for (int idx = 0; idx < numNodes; ++idx) {
            /* Create a list to store the neighbours of node idx */
            adjacencyLists[idx] = new ArrayList<Edge>();
        }
    }

    public int getNumNodes() {
        return this.numNodes;
    }

    public void addEdge(int source, int target, int weight) {
        adjacencyLists[source].add(new Edge(target, weight));
    }

    public ArrayList<Edge> getNeighbours(int node) {
        return adjacencyLists[node];
    }

}

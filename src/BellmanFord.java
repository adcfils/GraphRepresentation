

public class BellmanFord extends ShortestPath  {

    BellmanFord(DirectedGraph graph, int source) {
        super(graph, source - 1);
    }

    @Override
    public boolean computeShortestPath() {

        int numNodes = this.graph.getNumNodes();

        for (int i = 0; i < numNodes - 1; ++i) {
            for (int node = 0; node < numNodes; ++node) {
                for (Edge e : this.graph.getNeighbours(node)) {
                    relaxEdge(node, e);
                }
            }
        }

        /* Check for cycles */
        for (int node = 0; node < numNodes; ++node) {
            for (Edge e : this.graph.getNeighbours(node)) {
                if (relaxEdge(node, e)) {
                    return false;
                }
            }
        }

        return true;
    }
}

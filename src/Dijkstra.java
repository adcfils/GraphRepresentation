import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra extends ShortestPath {

    PriorityQueue<Edge> PQ;
    boolean visited[];

    Dijkstra(DirectedGraph graph, int source) {
        super(graph, source - 1);

        PQ      = new PriorityQueue<>();
        visited = new boolean[this.graph.getNumNodes()];
    }

    @Override
    public boolean computeShortestPath() {

        /* Add the source in the PQ */
        PQ.add(new Edge(this.source, 0));

        while (!PQ.isEmpty()) {

            /* Remove the closest unvisited node from the PQ */
            Edge e = PQ.poll();
            int currentNode = e.target();

            /* Ensure you don't explore a node twice */
            if (visited[currentNode]) {
                continue;
            }

            /* For each neighbour, attempt to find a better distance estimation */
            for (Edge link : this.graph.getNeighbours(currentNode)) {
                int neighbour = link.target();
                if (relaxEdge(currentNode, link)) {
                    PQ.add(new Edge(neighbour, minDist[neighbour]));
                }
            }

            /* Mark current node as visited */
            visited[currentNode] = true;
        }

        return true;
    }
}

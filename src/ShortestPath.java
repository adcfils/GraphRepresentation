import java.util.ArrayList;
import java.util.Collections;

abstract public class ShortestPath {

    DirectedGraph graph;

    final protected int source;
    protected int[] minDist;
    protected int[] parent;

    public ShortestPath(DirectedGraph graph, int source) {

        this.minDist = new int[graph.getNumNodes()];
        this.parent  = new int[graph.getNumNodes()];

        this.graph   = graph;
        this.source  = source;

        for (int i = 0; i < graph.getNumNodes(); ++i) {
            this.minDist[i] = Integer.MAX_VALUE;
            this.parent[i]  = -1;
        }
        this.minDist[source] = 0;

    }

    public boolean computeShortestPath() {
        return false;
    }

    double getDistance(int target) {
        return minDist[target];
    }

    ArrayList<Integer> getPath(int target) {

        ArrayList<Integer> path = new ArrayList<>();

        if (this.parent[target] == -1) {
            /* target isn't reachable */
            return path;
        }

        /* hop through each parent till we reach the source */
        for (int node = target; node != this.source; node = parent[node]) {
            path.add(target);
        }
        path.add(this.source);

        Collections.reverse(path);
        return path;
    }

    public boolean relaxEdge(int source, Edge e) {

        /* Check if you can improve the path estimation */
        /* to target node through the source node. */
        if (minDist[e.target()] > minDist[source] + e.weight()) {
            minDist[e.target()] = minDist[source] + e.weight();
            parent[e.target()]  = source;
            return true;
        }

        /* the distance estimation has remained the same */
        return false;
    }

    public void printDistances() {
        for (int i = 0;i < graph.getNumNodes(); ++i) {
            System.out.print(minDist[i] + " ");
        }
        System.out.println();
    }

}

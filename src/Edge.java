

public class Edge implements Comparable<Edge> {

    /* The target node */
    private final int target;

    /* The weight of the edge */
    private final int weight;

    public Edge(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }

    public int target() {
        return this.target;
    }

    public int weight() {
        return this.weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight();
    }
}






public class Tester {

    enum Algo {DIJKSTRA, BELLMAN_FORD};

    static final Algo TestAlgo = Algo.BELLMAN_FORD;

    static public void main(String... args) {

        DirectedGraph graph = IO.readGraph("test.in");
        ShortestPath algo;

        switch (TestAlgo) {

            case BELLMAN_FORD:
                algo = new BellmanFord(graph, 1);
                break;

            case DIJKSTRA:
            default:
                algo = new Dijkstra(graph, 1);
                break;
        }

        algo.computeShortestPath();
        algo.printDistances();
    }

}

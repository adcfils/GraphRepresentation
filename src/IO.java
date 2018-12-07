import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IO {

    static DirectedGraph readGraph(String inputFile) {

        try (Scanner S = new Scanner((new FileReader(inputFile)))) {

            int numNodes = S.nextInt();
            int numEdges = S.nextInt();

            DirectedGraph graph = new DirectedGraph(numNodes);

            for (int i = 0; i < numEdges; ++i) {
                int node1  = S.nextInt() - 1;
                int node2  = S.nextInt() - 1;
                int weight = S.nextInt();
                graph.addEdge(node1, node2, weight);
            }

            return graph;

        } catch (IOException e) {
            e.printStackTrace();
            Logger.getLogger(IO.class.getName()).log(Level.SEVERE, null, e);
        }

        return null;
    }

}

import graph_algorithms.Graph;
import graph_algorithms.GraphGenerator;

/**
 * Created by nicola on 25/04/17.
 */
public class Main {
    public static void main(String [] args){
        Graph g = new GraphGenerator().generateNonOrientedGraph();
    }
}

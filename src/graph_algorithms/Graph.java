package graph_algorithms;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nicola on 21/04/17.
 */
public class Graph {
    private HashMap<Node, ArrayList<Link>> structure;

    public Graph(HashMap<Node, ArrayList<Link>> structure) {
        this.structure = new HashMap<>();
    }

    //Getters and setters
    public HashMap<Node, ArrayList<Link>> getStructure() {
        return structure;
    }

    public void setStructure(HashMap<Node, ArrayList<Link>> structure) {
        this.structure = structure;
    }
}

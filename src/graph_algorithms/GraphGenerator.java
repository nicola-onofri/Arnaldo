package graph_algorithms;

import utils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * Created by nicola on 21/04/17.
 */
public class GraphGenerator {
    private final int n_nodes = 10;
    private final int n_links = 9; //must be at least equal to n_nodes-1
    private final int default_link_cost = 1;

    public Graph generateNonOrientedGraph() {
        if (n_nodes - 1 < n_links) {
            //TODO several controls here to be sure that the generated graph is both
            //TODO connected and there are no redoundant links
            System.out.println("Wrong parameters!");
            return null;
        }

        //Data structures
        ArrayList<Link> links = new ArrayList<>(n_links);
        ArrayList<Node> nodes = new ArrayList<>(n_nodes);
        ArrayList<Node> unbounded_nodes = new ArrayList<>(n_nodes);
        HashMap<Node, ArrayList<Link>> graph_structure = new HashMap<>();

        //Generate nodes
        for (int i = 0; i < n_nodes; i++) {
            Node n = new Node();
            nodes.add(n);
        }

        //Generate links
        for (int j = 0; j < n_links; j++) {
            Node src, dst;

            if (unbounded_nodes.size() == 0) {//links > nodes + 1
                //Select random nodes from the original list
                //At this point the graph can be considered connected
                src = nodes.get(Randoms.min_maxBoundedInt(0, nodes.size() - 1));
                dst = nodes.get(Randoms.min_maxBoundedInt(0, nodes.size() - 1));
            } else {
                src = unbounded_nodes.get(Randoms.min_maxBoundedInt(0, unbounded_nodes.size() - 1));
                unbounded_nodes.remove(src);

                if (unbounded_nodes.size() == 0) { //odd
                    //Select a random node from the original list, making sure that it's different from the one selected
                    ArrayList<Node> nodes_f = nodes.stream()
                            .filter(n -> !(n.equals(src)))
                            .collect(Collectors.toCollection(ArrayList::new));
                    dst = nodes_f.get(Randoms.min_maxBoundedInt(0, nodes_f.size() - 1));
                } else { //even
                    //Default case
                    dst = unbounded_nodes.get(Randoms.min_maxBoundedInt(0, unbounded_nodes.size() - 1));
                    unbounded_nodes.remove(dst);
                }
            }

            //TODO how can I start filling the HashMap here? This can decrease complexity!
            links.add(new Link(src, dst, default_link_cost));
        }


        //TODO move this for loop inside the previous one
        //Generate graph
        for (Node n : nodes) {
            ArrayList<Link> links_per_node = links.stream()
                    .filter(l -> l.getSrc().equals(n))
                    .collect(Collectors.toCollection(ArrayList::new));
            graph_structure.put(n, links_per_node);

            //Debug
//            System.out.print("Node: " + n.hashCode() + " links: ");
//            for (Link l : links_per_node)
//                System.out.print(l.hashCode() + " ");
//            System.out.print("\n");
        }

        for (Link l : links) {
            System.out.println("Link: " + l.hashCode() + " src: " + l.getSrc() + " dst: " + l.getDst());
        }
        return new Graph(graph_structure);
    }

    //non oriented graph -> adjacency matrix is symmetrical
//    public void nonOrientedAdjacencyMatrix(Graph g) {
//        int[][][] adj = new int[n_nodes][n_nodes][n_nodes];
//
//        ArrayList<Node> g_nodes = new ArrayList<>();
//        ArrayList<ArrayList<Link>> g_links = new ArrayList<>();
//        g.getStructure().keySet().addAll(g_nodes);
//        g.getStructure().values().addAll(g_links);
//
//        //TODO fix this
//        //Fill adjacency matrix with values
//        for (int i = 0; i < n_nodes; i++) {
//            System.out.println("Node: " + g_nodes.get(i).hashCode());
//            for (int j = 0; j < n_nodes; j++) {
//                System.out.println("Node: " + g_nodes.get(j).hashCode());
//                if (g_links.stream()
//                        .filter(l -> (l.getSrc().equals(g_nodes.get(i)) && l.getDst().equals(g_nodes.get(j)))
//                                || (l.getSrc().equals(g_nodes.get(j)) && l.getDst().equals(g_nodes.get(i))))
//                        .collect(Collectors.toCollection(ArrayList::new)).size() != 0) {
//                    ArrayList<Link> links_per_node = g_links.stream()
//                            .filter(l -> (l.getSrc().equals(g_nodes.get(i)) && l.getDst().equals(g_nodes.get(j)))
//                                    || (l.getSrc().equals(g_nodes.get(j)) && l.getDst().equals(g_nodes.get(i))))
//                            .collect(Collectors.toCollection(ArrayList::new));
//                    for (int l = 0; l < links_per_node.size(); l++) {
//                        adj[i][j][l] = links_per_node.get(l).hashCode();
//                        System.out.println(links_per_node.get(l).hashCode());
//                    }
//                    System.out.println("\t");
//                }
//            }
//            System.out.println("\n");
//        }
//    }
}

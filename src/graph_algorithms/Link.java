package graph_algorithms;

/**
 * Created by nicola on 21/04/17.
 */
public class Link {
    private Node src, dst;
    private int cost;
//    private String id;

    //Link class constructor
    public Link(Node src, Node dst, int cost) {
        this.src = src;
        this.dst = dst;
        this.cost = cost;
        //    this.id = link_id;
    }

    //Getters and setters
    public Node getSrc() {
        return src;
    }

    public void setSrc(Node src) {
        this.src = src;
    }

    public Node getDst() {
        return dst;
    }

    public void setDst(Node dst) {
        this.dst = dst;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

package class06;

/**
 * 边
 */

public class Edge {
    public int weight;  //边的权重
    public Node from;   //从哪出
    public Node to;     //从哪入

    public Edge(int weight, Node from, Node to) {
        this.weight = weight;
        this.from = from;
        this.to = to;
    }
}

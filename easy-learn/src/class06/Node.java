package class06;

import java.util.ArrayList;

/**
 * 图上的点
 */

public class Node {
    public int value;   //值大小
    public int in;      //入度
    public int out;     //出度
    public ArrayList<Node> nexts;   //直接邻居
    public ArrayList<Edge> edges;   //与改节点有关的边

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }
}

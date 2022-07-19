package class06;

import java.util.*;

/**
 * 拓扑排序
 */

public class TopologySort {

    public static List<Node> Topology(Graph graph) {
        HashMap<Node, Integer> inMap = new HashMap<>();     //节点与其对应的入度
        Queue<Node> queue = new LinkedList<>();     //让入度为0的节点入队列
        for (Node node : graph.nodes.values()) {
            inMap.put(node, node.in);
            if (node.in == 0) {
                queue.add(node);
            }
        }
        ArrayList<Node> nodeList = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            nodeList.add(node);
            for (Node next : node.nexts) {
                inMap.put(next, inMap.get(next) - 1);
                if (inMap.get(next) == 0) {
                    queue.add(next);
                }
            }
        }
        return nodeList;
    }
}

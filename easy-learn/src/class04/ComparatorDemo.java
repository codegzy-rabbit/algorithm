package class04;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(3);
        Node[] nodes = new Node[]{node, node1};
        Arrays.sort(nodes, new ComInteger());
        for (Node node2 : nodes) {
            System.out.println(node2.value);
        }
    }

    public static class ComInteger implements Comparator<Node> {

        @Override
        public int compare(Node o1, Node o2) {
            return o2.value - o1.value;
        }
    }
}

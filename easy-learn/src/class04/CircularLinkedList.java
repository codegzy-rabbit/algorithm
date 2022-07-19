package class04;

import java.util.HashSet;

/**
 * 判断一个链表是否有环，并找到入环的第一个节点
 */
public class CircularLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;
        Node loopNode = hashGetLoopNode(node1);
        System.out.println(loopNode.value);
    }

    //通过hashset获取入环首节点
    public static Node hashGetLoopNode(Node head){
        if (head == null || head.next == null){
            return null;
        }
        Node cur = head;
        HashSet<Node> nodes = new HashSet<>();
        while (nodes.add(cur)){
            cur = cur.next;
        }
        return cur;
    }

    //快慢指针获取入环首节点
    public static Node getLoopNode(Node head){
        Node slow = head.next, fast = head.next.next;
        if (head == null || slow == null || fast == null){
            return null;
        }
        while (slow != fast){
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

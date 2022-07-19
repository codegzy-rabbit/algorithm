package class04;

/**
 * 如果两个链表相交，求相交的节点
 */
public class TwoLinkedList {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(1);
        Node node6 = new Node(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node5.next = node6;
        node6.next = node3;
        Node node = getIntersectNode(node1, node5);
        if (node != null){
            System.out.println(node.value);
        }else {
            System.out.println("null");
        }
    }

    //如果两个链表相交，求相交的节点，否则就返回null
    public static Node getIntersectNode(Node head_one, Node head_two){
        if (head_one == null || head_two == null){
            return null;
        }
        int n = 0;
        Node cur_one = head_one, cur_two = head_two;
        while (cur_one.next != null){
            n++;
            cur_one = cur_one.next;
        }
        while (cur_two.next != null){
            n--;
            cur_two = cur_two.next;
        }
        if (cur_one != cur_two){
            return null;
        }

        cur_one = n > 0 ? head_one : head_two;
        cur_two = cur_one == head_one ? head_two : head_one;
        n = Math.abs(n);
        while (n > 0){
            cur_one = cur_one.next;
            n--;
        }

        while (cur_one != cur_two){
            cur_one = cur_one.next;
            cur_two = cur_two.next;
        }

        return cur_one;
    }

    //loop1为第一个链表入环的首节点，loop2是第二个的
    public static Node bothLoopNode(Node head1, Node loop1, Node head2, Node loop2){
        if (head1 == null || head1.next == null || head2 == null || head2.next == null){
            return null;
        }
        if (loop1 == loop2){
            int n = 0;
            Node cur1 = head1, cur2 = head2;
            while (cur1 != loop1){
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0){
                cur1 = cur1.next;
                n--;
            }
            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else {
            Node cur1 = loop1.next;
            while (cur1 != loop1){
                if (cur1 == loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
}

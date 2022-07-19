package class04;

import java.util.Stack;

/**
 * 判断一个链表是不是回文数
 */
public class Palindrome {
    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(3);
        Node node5 = new Node(2);
        Node node6 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        boolean b = Palindrome01(node1);
        System.out.println(b);
        boolean b1 = Palindrome02(node1);
        System.out.println(b1);
        boolean b2 = Palindrome03(node1);
        System.out.println(b2);

    }


    //判断是不是回文数  利用栈     空间O（N）
    public static boolean Palindrome01(Node head){
        Stack<Node> stack = new Stack<>();
        Node cur = head;
        //将节点全部进栈
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        //重新遍历比较
        cur = head;
        while (!stack.empty()){
            if (cur.value != stack.pop().value){
                return false;
            }
            cur = cur.next;
        }

        return true;
    }

    //利用快慢指针 + 栈    空间O（N/2）
    public static boolean Palindrome02(Node head){
        Stack<Node> stack = new Stack<>();
        Node slow = head, fast = head;
        //快慢指针
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node cur1 = head;
        Node cur2 = slow.next;
        while (cur2 != null){
            stack.push(cur2);
            cur2 = cur2.next;
        }
        while (!stack.empty()){
            if (cur1.value != stack.pop().value){
                return false;
            }
            cur1 = cur1.next;
        }
        return true;
    }

    //只要空间 O（1）的算法
    public static boolean Palindrome03(Node head){
        boolean flag = true;
        Node slow = head, fast = head;
        Node cur = head;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node P, Q, N;
        P = slow;
        Q = P.next;
        slow.next = null;
        N = null;
        while (Q != null){
            N = Q.next;
            Q.next = P;
            P = Q;
            Q = N;
        }
        Node cur2 = P;
        while (cur != null && P != null){
            if (cur.value != P.value){
                flag = false;
                break;
            }
            cur = cur.next;
            P = P.next;
        }
        P = cur2;
        Q = P.next;
        while (P != slow){
            N = Q.next;
            Q.next = P;
            P = Q;
            Q = N;
        }
        return flag;
    }
}

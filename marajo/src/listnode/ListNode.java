package listnode;

/**
 * @author GZY
 * @version 1.0
 * @date 2022/7/31 11:54
 */

/**
 * listnode
 */
public class ListNode {
    int value;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }
}

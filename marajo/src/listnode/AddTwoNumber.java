package listnode;

/**
 * @author GZY
 * @version 1.0
 * @date 2022/7/31 11:59
 */

/**
 * two linked lists store a digit number, each node's number plus then create a node store the number
 *
 * eg: 2 -> 5 -> 7 -> 3
 *       4 -> 2 -> 4
 *  ===>  6 -> 7 -> 8 -> 3
 */
public class AddTwoNumber {
    public static void main(String[] args) {
        ListNode l12 = new ListNode(2);
        ListNode l15 = new ListNode(5);
        ListNode l14 = new ListNode(7);
        ListNode l13 = new ListNode(3);
        l12.next = l15;
        l15.next = l14;
        l14.next = l13;
        ListNode l24 = new ListNode(4);
        ListNode l22 = new ListNode(2);
        ListNode l242 = new ListNode(4);
        l24.next = l22;
        l22.next = l242;
        ListNode result = solution(l12, l24);
        while (result != null) {
            System.out.println(result.value);
            result = result.next;
        }
    }

    private static ListNode solution(ListNode l1, ListNode l2) {
        // assign the l1 which the max length for the two lists
        l1 = calLenth(l1) >= calLenth(l2) ? l1 : l2;
        l2 = l1 == l1 ? l2 : l1;
        ListNode result = l1;
        // define the carry
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.value;
            int y = l2 == null ? 0 : l2.value;
            int temp = x + y + carry;
            l1.value = temp % 10 ;
            carry = temp / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry != 0) {
            l1.next = new ListNode(carry);
        }
        return result;
    }

    private static int calLenth(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

}

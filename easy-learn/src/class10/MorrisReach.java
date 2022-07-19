package class10;

/**
 * morris遍历
 */

public class MorrisReach {

    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        morrisPost(node1);
    }

    public static void morris(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        BinaryTreeNode cur = root;
        BinaryTreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {  //第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {    //第二次来到
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
    }

    public static void morriPre(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        BinaryTreeNode cur = root;
        BinaryTreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    System.out.println(cur.value);
                    cur = cur.left;
                    continue;
                } else {
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.value);
            }
            cur = cur.right;
        }
    }

    public static void morrisOrder(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        BinaryTreeNode cur = root;
        BinaryTreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {
                    System.out.println(cur.value);
                    mostRight.right = null;
                }
            } else {
                System.out.println(cur.value);
            }
            cur = cur.right;
        }
    }

    public static void morrisPost(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        BinaryTreeNode cur = root;
        BinaryTreeNode mostRight = null;
        while (cur != null) {
            mostRight = cur.left;
            if (mostRight != null) {
                while (mostRight.right != null && mostRight.right != cur) {
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null) {  //第一次来到cur
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {    //第二次来到
                    printEdge(cur.left);
                    mostRight.right = null;
                }
            }
            cur = cur.right;
        }
        printEdge(root);
    }

    public static BinaryTreeNode reverse(BinaryTreeNode from) {
        BinaryTreeNode pre = null;
        BinaryTreeNode next = null;
        if (from != null) {
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    public static void printEdge(BinaryTreeNode X) {
        BinaryTreeNode tail = reverse(X);
        BinaryTreeNode cur = tail;
        while (cur != null) {
            System.out.println(cur.value);
            cur = cur.right;
        }
        reverse(tail);
    }
}

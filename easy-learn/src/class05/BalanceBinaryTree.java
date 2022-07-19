package class05;

/**
 * 判定平衡二叉树
 */

public class BalanceBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node3 = new BinaryTreeNode(3);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node7;
        node7.left = node9;
        node3.right = node8;
        System.out.println(isBalance(node1).isBalanced);
    }

    public static class ReturnData {
        boolean isBalanced;
        int height;
        public ReturnData(boolean isBalanced, int height){
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static ReturnData isBalance(BinaryTreeNode root){
        if (root == null){
            return new ReturnData(true, 0);
        }
        ReturnData left = isBalance(root.left);
        ReturnData right = isBalance(root.right);
        boolean isBalanced = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) < 2;
        int height = Math.max(left.height, right.height) + 1;
        return new ReturnData(isBalanced, height);
    }
}

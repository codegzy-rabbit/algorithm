package class05;

/**
 * 满二叉树的判定
 */

public class FullBinaryTree {
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
        node3.left = node4;
        ReturnData data = isFull(node1);
        System.out.println(data.node_num == ((int) Math.pow(2, data.height) - 1));
    }

    public static class ReturnData {
        int height;
        int node_num;
        public ReturnData(int height, int node_num){
            this.height = height;
            this.node_num = node_num;
        }
    }

    public static ReturnData isFull(BinaryTreeNode root){
        if (root == null){
            return new ReturnData(0, 0);
        }
        ReturnData left = isFull(root.left);
        ReturnData right = isFull(root.right);
        int height = (Math.max(left.height, right.height)) + 1;
        int node_num = left.node_num + right.node_num + 1;
        return new ReturnData(height, node_num);
    }
}

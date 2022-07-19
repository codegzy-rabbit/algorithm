package class05;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一个二叉树是不是完全二叉树
 */

public class CompleteBinaryTree {
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
        node3.left = node8;
        System.out.println(Complete(node1));
    }

    public static boolean Complete(BinaryTreeNode root){
        if (root == null){
            return true;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        BinaryTreeNode left = null;
        BinaryTreeNode right = null;
        boolean leaf = false;   //判断有没有出现叶子节点
        queue.add(root);
        while (!queue.isEmpty()){
            root = queue.poll();
            left = root.left;
            right = root.right;
            if ((left == null && right != null) || (leaf && (left != null || right != null))){
                return false;
            }
            if (left != null){
                queue.add(left);
            }
            if (right != null){
                queue.add(right);
            }
            if (left == null || right == null){
                leaf = true;
            }
        }
        return true;
    }
}

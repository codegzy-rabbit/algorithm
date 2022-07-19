package class05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树的序列化和反序列化
 */

public class SerializationTree {
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
        String s = SerializationBinaryTree(node1);
        System.out.println(s);
        BinaryTreeNode node = reconPreString(s);
        inOrderTraversal(node);
    }

    public static String SerializationBinaryTree(BinaryTreeNode root){
        if (root == null){
            return "#_";
        }
        String res = root.value + "_";
        res += SerializationBinaryTree(root.left);
        res += SerializationBinaryTree(root.right);
        return res;
    }

    public static BinaryTreeNode reconPreString(String res){
        String[] s = res.split("_");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < s.length; i++){
            queue.add(s[i]);
        }
        return reconPreOrder(queue);
    }

    public static BinaryTreeNode reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        if ("#".equals(value)){
            return null;
        }
        BinaryTreeNode root = new BinaryTreeNode(Integer.valueOf(value));
        root.left = reconPreOrder(queue);
        root.right = reconPreOrder(queue);
        return root;
    }

    public static void inOrderTraversal(BinaryTreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.value);
        inOrderTraversal(root.left);
        inOrderTraversal(root.right);
    }
}

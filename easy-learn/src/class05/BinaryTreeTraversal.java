package class05;

import java.util.Stack;

//二叉树的各种遍历  递归及非递归
public class BinaryTreeTraversal {
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
        postOrderDisplay(node1);
    }


    //递归先序遍历
    public static void preOrderTraversal(BinaryTreeNode root){
        if (root == null){
            return;
        }
        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    //递归中序遍历
    public static void inOrderTraversal(BinaryTreeNode root){
        if (root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }

    //递归后序遍历
    public static void postOrderTraversal(BinaryTreeNode root){
        if (root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value);
    }

    //非递归先序遍历
    public static void preOrderDisplay(BinaryTreeNode root){
        if (root == null){
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            BinaryTreeNode node = stack.pop();
            System.out.println(node.value);
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
    }

    //非递归中序遍历
    public static void inOrderDisplay(BinaryTreeNode root){
        if (root == null){
            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()){
            if (root != null){
                stack.push(root);
                root = root.left;
            }else {
                root = stack.pop();
                System.out.println(root.value);
                root = root.right;
            }
        }
    }

    //非递归后序遍历
    public static void postOrderDisplay(BinaryTreeNode root){
        if (root == null){
            return;
        }
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            root = stack1.pop();
            stack2.push(root);
            if (root.left != null){
                stack1.push(root.left);
            }
            if (root.right != null){
                stack1.push(root.right);
            }
        }
        while (!stack2.isEmpty()){
            System.out.println(stack2.pop().value);
        }
    }
}

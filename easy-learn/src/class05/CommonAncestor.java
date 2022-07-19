package class05;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 两个节点的公共最低祖先
 */

public class CommonAncestor {
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
        node3.right = node6;
        node2.left = node4;
        node2.right = node5;
        System.out.println(Recure(node1, node4, node6).value);
    }

    public static BinaryTreeNode Common(BinaryTreeNode root, BinaryTreeNode o1, BinaryTreeNode o2){
        HashMap<BinaryTreeNode, BinaryTreeNode> map = new HashMap<>();
        map.put(root, root);
        process(root, map);
        HashSet<BinaryTreeNode> set = new HashSet<>();
        BinaryTreeNode cur = o1;
        while (cur != map.get(cur)){
            set.add(cur);
            cur = map.get(cur);
        }
        set.add(root);

        while (set.add(o2)){
            o2 = map.get(o2);
        }
        return o2;
    }

    public static void process(BinaryTreeNode root, HashMap<BinaryTreeNode, BinaryTreeNode> map){
        if (root == null){
            return;
        }
        map.put(root.left, root);
        map.put(root.right, root);
        process(root.left, map);
        process(root.right, map);
    }

    public static BinaryTreeNode Recure(BinaryTreeNode root, BinaryTreeNode o1, BinaryTreeNode o2){
        if (root == null || o1 == root || o2 == root){
            return root;
        }
        BinaryTreeNode left = Recure(root.left, o1, o2);
        BinaryTreeNode right = Recure(root.right, o1, o2);
        if (left != null && right != null){
            return root;
        }
        return left != null ? left : right;
    }
}

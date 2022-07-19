package class05;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 获取二叉树的宽度
 */

public class BinaryTreeWidth {
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
        System.out.println(getTreeWidth(node1));
    }

    public static int getTreeWidth(BinaryTreeNode root){
        if (root == null){
            return 0;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        Map<BinaryTreeNode, Integer> levelMap = new HashMap<>();     //统计节点在哪一层
        levelMap.put(root, 1);
        int currentLevel = 1;   //现在所在层数
        int currentLevelNodes = 0;  //现在所在层数的节点总数
        int max = Integer.MIN_VALUE;    //某层的最大节点数
        while (!queue.isEmpty()){
            BinaryTreeNode cur = queue.poll();
            Integer curNodeLevel = levelMap.get(cur);
            if (curNodeLevel == currentLevel){
                currentLevelNodes++;
            }else {
                max = Math.max(max, currentLevelNodes);
                currentLevelNodes = 1;
                currentLevel++;
            }
            if (cur.left != null){
                levelMap.put(cur.left, curNodeLevel + 1);
                queue.add(cur.left);
            }
            if (cur.right != null){
                levelMap.put(cur.right, curNodeLevel + 1);
                queue.add(cur.right);
            }
        }
        return max;
    }
}

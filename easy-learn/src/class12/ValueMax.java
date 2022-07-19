package class12;

/**
 * 二叉树节点右int值，给定一颗二叉树，计算从根节点到叶节点权值和最大为多少
 */

public class ValueMax {

    public static int getMaxValue(BinaryTreeNode root) {
        if (root.left == null && root.right == null) {
            return root.value;
        }
        int max = Integer.MIN_VALUE;
        if (root.left != null) {
            max = getMaxValue(root.left);
        }
        if (root.right != null) {
            max = Math.max(max, getMaxValue(root.right));
        }
        return root.value + max;
    }

}

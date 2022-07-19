package class10;

/**
 * 求一个树中两个节点的最大距离
 */

public class TwoNodeDistance {
    public static void main(String[] args) {

    }

    public static Info getMaxDistance(BinaryTreeNode root) {
        if (root == null) {
            return new Info(0, 0);
        }
        Info left = getMaxDistance(root.left);
        Info right = getMaxDistance(root.right);
        int p1 = left.distance;
        int p2 = right.distance;
        int p3 = left.height + right.height + 1;
        int maxDistance = Math.max(p1, Math.max(p2, p3));
        int height = Math.max(left.height, right.height) + 1;
        return new Info(maxDistance, height);
    }

    public static class Info {
        public int distance;
        public int height;

        public Info(int distance, int height) {
            this.distance = distance;
            this.height = height;
        }
    }

}

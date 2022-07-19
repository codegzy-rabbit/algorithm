package class05;

/**
 * 判断一个二叉树是否为搜索二叉树
 */

public class SearchBinaryTree {
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
        node4.left = node5;
        node2.left = node1;
        node2.right = node3;
        node4.right = node2;
        System.out.println(Recure(node4).b);

    }

    public static int preValue = Integer.MIN_VALUE;
    //方法1
    public static boolean SearchTree(BinaryTreeNode root){
        if (root == null){
            return true;
        }
        boolean b = SearchTree(root.left);
        if (!b){
            return false;
        }
        if (root.value < preValue){
            return false;
        }else {
            preValue = root.value;
        }
        return SearchTree(root.right);
    }

    //方法2
    public static class ReturnData {
        boolean b;
        int min;
        int max;
        public ReturnData(boolean b, int min, int max){
            this.b = b;
            this.min = min;
            this.max = max;
        }
    }

    public static ReturnData Recure(BinaryTreeNode root){
        if (root == null){
            return null;
        }
        ReturnData left = Recure(root.left);
        ReturnData right = Recure(root.right);

        int min = root.value;
        int max = root.value;
        if (left != null){
            max = Math.max(max, left.max);
        }
        if (right != null){
            min = Math.min(min, right.min);
        }

        boolean isBST = true;
        if (left != null && (left.max > root.value || !left.b)){
            isBST = false;
        }
        if (right != null && (right.min < root.value || !right.b)){
            isBST = false;
        }

        return new ReturnData(isBST, min, max);
    }
}

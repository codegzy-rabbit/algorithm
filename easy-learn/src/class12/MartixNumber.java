package class12;

/**
 * 行升序，列升序，找一个数是否在矩阵中
 */

public class MartixNumber {

    public static boolean isExist(int[][] M, int target) {
        int row = M.length;
        int col = M[0].length;
        int i = 0;
        int j = col - 1;
        while (j >= 0 && i < row) {
            if (target == M[i][j]) {
                return true;
            }
            if (target < M[i][j]) {
                j--;
            }
            if (target > M[i][j]) {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] M = {
                {1, 7, 13},
                {8, 10, 16},
                {9, 11, 19}
        };
        System.out.println(isExist(M, 9));
    }

}

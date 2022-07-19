package class11;

/**
 * 两个人只能从数组最左和最右拿数，返回那个数大的人
 */

public class CardsInLine {

    /**
     * 先手函数，谁先拿数肯定是先拿大的那个
     * 如果只有一个数就直接返回
     * 否则就拿数组中最左或最右的数和后手的人拿过后的值
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public static int pre(int[] arr, int i, int j) {
        if (i == j) {
            return arr[i];
        }
        return Math.max(
                arr[i] + post(arr, i + 1, j),
                arr[j] + post(arr, i, j - 1)
        );
    }

    /**
     * 后手函数如果没有数直接返回0
     * 如果有则拿到的是先手人拿过后数组的小的值
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public static int post(int[] arr, int i, int j) {
        if (i == j) {
            return 0;
        }
        return Math.min(
                pre(arr, i + 1, j),
                pre(arr, i, j - 1)
        );
    }


    public static int dp(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int N = arr.length;
        int[][] pre = new int[N][N];
        int[][] post = new int[N][N];

        for (int i = 0; i < N; i++) {
            pre[i][i] = arr[i];
        }

        int row = 0;
        int col = 1;
        while (col < N) {
            int i = row;
            int j = col;
            while (i < arr.length && j < arr.length) {
                pre[i][j] = Math.max(arr[i] + post[i + 1][j], arr[j] + post[i][j - 1]);
                post[i][j] = Math.min(pre[i + 1][j], pre[i][j - 1]);
                i++;
                j++;
            }
            col++;
        }
        return pre[0][N - 1];
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 1};
        System.out.println(pre(arr, 0, arr.length - 1));
        System.out.println(post(arr, 0, arr.length - 1));
        System.out.println(dp(arr));
    }

}

package class11;

/**
 * 🐎从(0,0)开始跳，在K步后跳到某个位置总方法数
 */

public class HorseJump {


    /**
     * @param arr 棋盘大小
     * @param x   终点位置的X
     * @param y   终点位置的Y
     * @param K   总步数K
     * @return 总方法数
     */
    public static int jump(int[][] arr, int x, int y, int K) {
        if (x < 0 || x > arr.length || y < 0 || y > arr[0].length) {
            return 0;
        }
        if (K == 0) {
            return x == 0 && y == 0 ? 1 : 0;
        }
        return jump(arr, x - 1, y + 2, K - 1)
                + jump(arr, x + 1, y + 2, K - 1)
                + jump(arr, x + 1, y - 2, K - 1)
                + jump(arr, x - 1, y - 2, K - 1)
                + jump(arr, x - 2, y + 1, K - 1)
                + jump(arr, x + 2, y + 1, K - 1)
                + jump(arr, x - 2, y - 1, K - 1)
                + jump(arr, x + 2, y - 1, K - 1);
    }


    /**
     * 动态规划
     *
     * @param x
     * @param y
     * @param K
     * @return
     */
    public static int dpNumber(int x, int y, int K) {
        if (x < 0 || x > 8 || y < 0 || y > 9 || K < 0) {
            return 0;
        }
        int[][][] dp = new int[9][10][K + 1];
        dp[0][0][0] = 1;
        for (int h = 1; h < K + 1; h++) {
            for (int r = 0; r < 9; r++) {
                for (int c = 0; c < 10; c++) {
                    dp[r][c][h] += getValue(dp, r - 1, c + 2, h - 1);
                    dp[r][c][h] += getValue(dp, r - 1, c - 2, h - 1);
                    dp[r][c][h] += getValue(dp, r + 1, c + 2, h - 1);
                    dp[r][c][h] += getValue(dp, r + 1, c - 2, h - 1);
                    dp[r][c][h] += getValue(dp, r - 2, c + 1, h - 1);
                    dp[r][c][h] += getValue(dp, r - 2, c - 1, h - 1);
                    dp[r][c][h] += getValue(dp, r + 2, c + 1, h - 1);
                    dp[r][c][h] += getValue(dp, r + 2, c - 1, h - 1);
                }
            }
        }
        return dp[x][y][K];
    }

    public static int getValue(int[][][] dp, int x, int y, int K) {
        if (x < 0 || x > 8 || y < 0 || y > 9) {
            return 0;
        }
        return dp[x][y][K];
    }

    public static void main(String[] args) {
        int[][] arr = new int[8][9];
        System.out.println(jump(arr, 7, 7, 10));

        System.out.println(dpNumber(7, 7, 10));
    }

}

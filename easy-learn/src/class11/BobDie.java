package class11;

/**
 * bob在一个N*M区域里走完K步后还在这个区域的方法数
 */

public class BobDie {

    /**
     * @param N
     * @param M
     * @param x
     * @param y
     * @param rest 剩余步数
     * @return
     */
    public static long process(int N, int M, int x, int y, int rest) {
        if (x < 0 || x >= N || y < 0 || y >= M) {
            return 0;
        }
        if (rest == 0) {
            return 1;
        }
        return process(N, M, x - 1, y, rest - 1)
                + process(N, M, x + 1, y, rest - 1)
                + process(N, M, x, y + 1, rest - 1)
                + process(N, M, x, y - 1, rest - 1);
    }


    /**
     * 动态规划
     *
     * @param N
     * @param M
     * @param x
     * @param y
     * @param rest
     * @return
     */
    public static long dpNumber(int N, int M, int x, int y, int rest) {
        int[][][] dp = new int[N + 2][M + 2][rest + 1];
        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < M + 1; j++) {
                dp[i][j][0] = 1;
            }
        }
        for (int h = 1; h < rest + 1; h++) {
            for (int i = 1; i < N + 1; i++) {
                for (int j = 1; j < M + 1; j++) {
                    dp[i][j][h] = dp[i - 1][j][h - 1];
                    dp[i][j][h] += dp[i + 1][j][h - 1];
                    dp[i][j][h] += dp[i][j + 1][h - 1];
                    dp[i][j][h] += dp[i][j - 1][h - 1];
                }
            }
        }
        return dp[x][y][rest];
    }


    public static void main(String[] args) {
        System.out.println(process(7, 7, 3, 4, 5));
        System.out.println(dpNumber(7, 7, 3, 4, 5));
    }

}

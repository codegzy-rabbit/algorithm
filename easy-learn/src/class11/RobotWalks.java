package class11;

/**
 * 给定一个总长度N
 * 目标位置E
 * 给一个指定长度的步数，在步数耗完后从起始位置到达目标位置的方法总数
 */

public class RobotWalks {


    /**
     * 暴力递归的方法求解
     *
     * @param N 总位置大小
     * @param E 目标位置
     * @param K 剩余步数
     * @param C 目前的位置
     * @return 可行的方法数
     */
    public static int process1(int N, int E, int K, int C) {
        if (K == 0) {
            return C == E ? 1 : 0;
        }
        if (C == 1) {
            return process1(N, E, K - 1, C + 1);
        }
        if (C == N) {
            return process1(N, E, K - 1, C - 1);
        }
        return process1(N, E, K - 1, C - 1) + process1(N, E, K - 1, C + 1);
    }


    /**
     * 记忆化搜索解决问题
     *
     * @param N  总位置大小
     * @param E  目标位置
     * @param K  剩余步数
     * @param C  目前的位置
     * @param dp 缓存数组
     * @return 可行的方法数
     */
    public static int process2(int N, int E, int K, int C, int[][] dp) {
        if (dp[K][C] != 0) {
            return dp[K][C];
        }
        if (K == 0) {
            dp[K][C] = C == E ? 1 : 0;
            return dp[K][C];
        }
        if (C == 1) {
            dp[K][C] = process1(N, E, K - 1, C + 1);
        } else if (C == N) {
            dp[K][C] = process1(N, E, K - 1, C - 1);
        } else {
            dp[K][C] = process1(N, E, K - 1, C - 1) + process1(N, E, K - 1, C + 1);
        }

        return dp[K][C];
    }

    /**
     * 严格表结构
     *
     * @param N  总位置大小
     * @param E  目标位置
     * @param K  剩余步数
     * @param C  目前的位置
     * @param dp 缓存数组
     * @return 可行的方法数
     */
    public static int process3(int N, int E, int K, int C, int[][] dp) {
        dp[0][C] = 1;
        for (int i = 1; i < K; i++) {
            for (int j = 1; j < N; j++) {
                if (j == 1) {
                    dp[i][j] = dp[i - 1][j + 1];
                } else if (j == N) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j + 1] + dp[i - 1][j - 1];
                }
            }
        }
        return dp[K][C];
    }

    public static void main(String[] args) {
        int[][] dp = new int[5][6];
        System.out.println(process1(5, 4, 4, 2));
        System.out.println(process2(5, 4, 4, 2, dp));
        System.out.println(process3(5, 4, 4, 2, dp));
    }
}

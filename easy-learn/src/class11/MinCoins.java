package class11;

/**
 * 一个数组有不同的金额的硬币
 * 找到硬币金额和为target的最小硬币数
 */

public class MinCoins {

    /**
     * 暴力递归
     *
     * @param arr   硬币金额数组
     * @param index 当前硬币的位置
     * @param rest  剩余金额
     * @return 最小硬币数
     */
    public static int process1(int[] arr, int index, int rest) {
        if (rest < 0) {
            return -1;
        }
        if (rest == 0) {
            return 0;
        }

        //rest > 0
        if (index == arr.length) {
            return -1;
        }
        //当前硬币不要
        int p1 = process1(arr, index + 1, rest);
        //要当前硬币
        int p2 = process1(arr, index + 1, rest - arr[index]);
        if (p1 == -1 && p2 == -1) {
            return -1;
        } else {
            if (p1 == -1) {
                return p2 + 1;
            } else if (p2 == -1) {
                return p1;
            } else {
                return Math.min(p1, p2 + 1);
            }
        }
    }

    /**
     * 记忆化搜索
     *
     * @param arr   硬币金额数组
     * @param index 当前硬币的位置
     * @param rest  剩余金额
     * @param dp    缓存数组
     * @return 最小硬币数
     */
    public static int process2(int[] arr, int index, int rest, int[][] dp) {
        if (rest < 0) {
            return -1;
        }
        if (dp[index][rest] != -2) {
            return dp[index][rest];
        }
        if (rest == 0) {
            dp[index][rest] = 0;
            return dp[index][rest];
        }
        if (index == arr.length) {
            dp[index][rest] = -1;
            return dp[index][rest];
        }

        //当前硬币不要
        int p1 = process1(arr, index + 1, rest);
        //要当前硬币
        int p2 = process1(arr, index + 1, rest - arr[index]);
        if (p1 == -1 && p2 == -1) {
            dp[index][rest] = -1;
        } else {
            if (p1 == -1) {
                dp[index][rest] = p2 + 1;
            } else if (p2 == -1) {
                dp[index][rest] = p1;
            } else {
                dp[index][rest] = Math.min(p1, p2 + 1);
            }
        }
        return dp[index][rest];
    }


    /**
     * 严格表结构
     *
     * @param arr  硬币金额数组
     * @param rest 剩余金额
     * @return 最小硬币数
     */
    public static int process3(int[] arr, int rest) {
        int N = arr.length;
        int[][] dp = new int[N + 1][rest + 1];
        for (int i = 0; i < N + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 1; i < rest + 1; i++) {
            dp[N][i] = -1;
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = 1; j < rest + 1; j++) {

                int p1 = dp[i + 1][j];
                int p2 = -1;
                if (j - arr[i] >= 0) {
                    p2 = dp[i + 1][j - arr[i]];
                }
                if (p1 == -1 && p2 == -1) {
                    dp[i][j] = -1;
                } else {
                    if (p1 == -1) {
                        dp[i][j] = p2 + 1;
                    } else if (p2 == -1) {
                        dp[i][j] = p1;
                    } else {
                        dp[i][j] = Math.min(p1, p2 + 1);
                    }
                }

            }

        }
        return dp[0][rest];

    }

    public static int displayProcess2(int[] arr, int index, int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];
        for (int i = 0; i < arr.length + 1; i++) {
            for (int j = 0; j < aim + 1; j++) {
                dp[i][j] = -2;
            }
        }
        return process2(arr, index, aim, dp);
    }

    public static void main(String[] args) {
        int[] coin = new int[]{2, 3, 5, 3};
        System.out.println(process1(coin, 0, 10));
        System.out.println(displayProcess2(coin, 0, 10));
        System.out.println(process3(coin, 10));
    }

}

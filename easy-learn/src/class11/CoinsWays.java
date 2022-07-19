package class11;

/**
 * 1，5，10，20，50
 * <p>
 * 100块找零有多少种方法
 */

public class CoinsWays {


    /**
     * @param arr   零钱数组
     * @param index 当前所在零钱的下标
     * @param rest  剩余需要找零的钱数
     * @return 找零的方法总数
     */
    public static int way1(int[] arr, int index, int rest) {
        if (index == arr.length) {
            return rest == 0 ? 1 : 0;
        }
        int way = 0;
        for (int zhang = 0; arr[index] * zhang <= rest; zhang++) {
            way += way1(arr, index + 1, rest - arr[index] * zhang);
        }
        return way;
    }

    public static int way2(int[] arr, int index, int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];
        dp[arr.length][0] = 1;
        for (int row = arr.length - 1; row >= 0; row--) {
            for (int col = 0; col <= aim; col++) {
                int ways = 0;
                for (int zhang = 0; arr[row] * zhang <= col; zhang++) {
                    ways += dp[row + 1][col - arr[row] * zhang];
                }
                dp[row][col] = ways;
            }
        }
        return dp[index][aim];
    }

    public static int way3(int[] arr, int index, int aim) {
        int[][] dp = new int[arr.length + 1][aim + 1];
        dp[arr.length][0] = 1;
        for (int row = arr.length - 1; row >= 0; row--) {
            for (int col = 0; col <= aim; col++) {
                dp[row][col] = dp[row + 1][col];
                if (col - arr[row] >= 0) {
                    dp[row][col] += dp[row][col - arr[row]];
                }
            }
        }
        return dp[index][aim];
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 10};
        System.out.println(way1(arr, 0, 100));
        System.out.println(way2(arr, 0, 100));
        System.out.println(way3(arr, 0, 100));
    }

}

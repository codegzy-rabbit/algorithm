package class12;

/**
 * 给一个非负数n，返回能形成二叉树不同结构的个数
 */

public class TreeNumber {

    public static int getTreeNumber(int N) {
        if (N < 0) {
            return 0;
        }
        if (N == 1) {
            return 1;
        }
        if (N == 2) {
            return 2;
        }
        int res = 0;
        for (int leftNum = 0; leftNum <= N - 1; leftNum++) {
            int leftWays = getTreeNumber(leftNum);
            int rightWays = getTreeNumber(N - 1 - leftNum);
            res += leftWays * rightWays;
        }
        return res;
    }

    public static int getTreeNumber1(int N) {
        if (N < 2) {
            return 1;
        }
        int[] dp = new int[N + 1];
        dp[0] = 1;
        for (int i = 1; i <= N - 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(getTreeNumber(5));
        System.out.println(getTreeNumber1(5));
    }

}

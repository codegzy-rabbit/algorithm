package class12;

public class MaxKuoHaoString {

    public static int[] maxKuoHao(String s) {
        char[] chars = s.toCharArray();
        int N = chars.length;
        int[] dp = new int[N];
        int pre = 0;
        for (int i = 1; i < N; i++) {
            if (chars[i] == ')') {
                pre = i - dp[i - 1] - 1;
                if (pre >= 0 && chars[pre] == '(')
                    dp[i] = 2 + dp[i - 1] + (pre > 0 ? dp[pre - 1] : 0);
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        String s = "((())()())";
        for (int i : maxKuoHao(s)) {
            System.out.println(i);
        }
    }
}

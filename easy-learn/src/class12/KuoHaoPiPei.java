package class12;

/**
 * 给一个只含括号的字符串判断其是否匹配完整
 * <p>
 * 判断一个括号字符串的深度
 */

public class KuoHaoPiPei {

    public static boolean panDuan(String s) {
        char[] chars = s.toCharArray();
        int N = chars.length;
        int count = 0;
        for (int i = 0; i < N; i++) {
            if (chars[i] == '(') {
                count++;
            } else {
                count--;
            }
            if (count < 0) {
                return false;
            }
        }
        if (count > 0) {
            return false;
        }
        return true;
    }

    public static int deep(String s) {
        char[] chars = s.toCharArray();
        int N = chars.length;
        int count = 0;
        int maxDeep = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (chars[i] == '(') {
                count++;
            } else {
                count--;
            }
            maxDeep = Math.max(count, maxDeep);
        }
        return maxDeep;
    }

    public static void main(String[] args) {
        String s = "(()()((())))";
        System.out.println(panDuan(s));
        System.out.println(deep(s));
    }

}

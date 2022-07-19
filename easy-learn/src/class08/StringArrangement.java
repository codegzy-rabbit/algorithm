package class08;

/**
 * 字符串的全排列
 */

public class StringArrangement {
    public static void main(String[] args) {
        arrangeMent("abcd".toCharArray(), 0);
    }

    public static void arrangeMent(char[] str, int i) {
        if (i == str.length) {
            System.out.println(String.valueOf(str));
        }
        boolean[] visit = new boolean[26];
        for (int j = i; j < str.length; j++) {
            if (!visit[str[j] - 'a']) {
                visit[str[j] - 'a'] = true;
                swap(str, i, j);
                arrangeMent(str, i + 1);
                swap(str, i, j);
            }
        }
    }

    public static void swap(char[] str, int i, int j) {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}

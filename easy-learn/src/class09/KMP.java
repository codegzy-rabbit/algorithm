package class09;

/**
 * KMP算法
 */

public class KMP {
    public static void main(String[] args) {

    }

    public static int[] getNextArray(char[] chars) {
        if (chars.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[chars.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int cn = 0;
        while (i < chars.length) {
            if (chars[i - 1] == chars[cn]) {
                next[i++] = ++cn;
            } else if (cn > 0) {
                cn = next[cn];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static int getIndexOf(String s, String m) {
        if (s == null || m == null || s.length() < 1 || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        char[] schar = s.toCharArray();
        char[] mchar = m.toCharArray();
        int[] nextArray = getNextArray(mchar);
        int i = 0;
        int j = 0;
        while (i < schar.length && j < mchar.length) {
            if (schar[i] == mchar[j]) {
                i++;
                j++;
            } else if (nextArray[j] == -1) {
                i++;
            } else {
                j = nextArray[j];
            }
        }
        return j == mchar.length ? i - j : -1;
    }
}

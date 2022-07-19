package class09;

/**
 * 改进版的最大回文子串
 */


public class Manacher {
    public static void main(String[] args) {

    }

    public static char[] getManacher(String str) {
        char[] chars = str.toCharArray();
        char[] palindrome = new char[chars.length * 2 + 1];
        int index = 0;
        for (int i = 0; i < palindrome.length; i++) {
            palindrome[i] = (i & 1) == 0 ? '#' : chars[index++];
        }
        return palindrome;
    }

    public static int palindromeString(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] manacher = getManacher(str);     //处理字符串
        int[] pArr = new int[manacher.length];      //回文半径数组
        int C = -1;     //中心
        int R = -1;     //回文右边界再往右个一个位置     最右有效区是R-1
        int max = Integer.MIN_VALUE;    //最大回文长度       扩出来的最大值
        for (int i = 0; i < manacher.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            while (i + pArr[i] < manacher.length && i - pArr[i] > -1) {
                if (manacher[i + pArr[i]] == manacher[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) {
                R = i + pArr[i];
                C = i;
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }
}

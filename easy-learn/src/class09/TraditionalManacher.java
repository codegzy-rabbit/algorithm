package class09;

/**
 * 传统求字符串的最大回文子串
 */

public class TraditionalManacher {
    public static void main(String[] args) {
        String str = "abbacabba";
        System.out.println(palindromeString(str));
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
        int j = 0, k = 0, max = Integer.MIN_VALUE;
        char[] manacher = getManacher(str);
        for (int i = 0; i < manacher.length; i++) {
            j = i;
            k = i;
            while (j >= 0 && k < manacher.length && manacher[j] == manacher[k]) {
                j--;
                k++;
            }
            max = Math.max(max, k - j - 1);
        }
        return max / 2;
    }

}

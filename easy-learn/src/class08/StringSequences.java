package class08;

/**
 * 打印一个字符串所有的子序列串，包括空
 */

public class StringSequences {
    public static void main(String[] args) {
        String str = "abc";
        printString(str.toCharArray(), 0);
    }

    public static void printString(char[] str, int i) {
        if (i == str.length) {
            System.out.println(String.valueOf(str));
            return;
        }
        printString(str, i + 1);
        char temp = str[i];
        str[i] = 0;
        printString(str, i + 1);
        str[i] = temp;
    }
}

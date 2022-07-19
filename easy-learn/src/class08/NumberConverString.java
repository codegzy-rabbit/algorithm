package class08;

/**
 * 将一串数字转换为字符串  1->A 2->B 11->K
 * 问有多少中转换方式
 */

public class NumberConverString {
    public static void main(String[] args) {

    }

    public static int conver(char[] str, int i) {
        if (i == str.length) {
            return 1;
        }
        if (str[i] == '0') {
            return 0;
        }
        if (str[i] == '1') {
            int res = conver(str, i + 1);
            if (i + 1 < str.length) {
                res += conver(str, i + 2);
            }
            return res;
        }
        if (str[i] == '2') {
            int res = conver(str, i + 1);
            if (i + 1 < str.length && (str[i + 1] >= '0' && str[i + 1] <= '6')) {
                res += conver(str, i + 2);
            }
            return res;
        }
        return conver(str, i + 1);
    }
}

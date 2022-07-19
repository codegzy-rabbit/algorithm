package class10;

/**
 * 不通过比较运算符就比较两个数哪个大
 */

public class TwoNumMax {

    //
    public static int flip(int n) {
        return n ^ 1;
    }

    //获得符号位，经过flip函数所以 1是正 0是负
    public static int sign(int n) {
        return flip((n >> 31) & 1);
    }

    public static int getMax(int a, int b) {
        int c = a - b;
        int scA = sign(c);
        int scB = flip(scA);
        return a * scA + b * scB;
    }

    public static int getMax2(int a, int b) {
        int c = a - b;
        int sa = sign(a);
        int sb = sign(b);
        int sc = sign(c);
        int difSab = sa ^ sb;
        int sameSab = flip(difSab);
        int returnA = difSab * sa + sameSab * sc;
        int returnB = flip(returnA);
        return a * returnA + b * returnB;
    }

    public static void main(String[] args) {
        System.out.println(getMax(1, 3));
        System.out.println(getMax2(6, 2));
    }
}

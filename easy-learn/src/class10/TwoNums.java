package class10;

/**
 * 两个数不通过算术运算符，完成加减乘除
 */

public class TwoNums {

    public static boolean isNeg(int n) {
        return n < 0;
    }

    public static int div(int a, int b) {
        int x = isNeg(a) ? negNum(a) : a;
        int y = isNeg(b) ? negNum(b) : b;
        int res = 0;
        for (int i = 31; i >= 0; i = sub(i, 1)) {
            if ((x >> i) >= y) {
                res |= (1 << i);
                x = sub(x, y << i);
            }
        }
        return isNeg(a) ^ isNeg(b) ? negNum(res) : res;
    }

    public static int multi(int a, int b) {
        int res = 0;
        while (b != 0) {
            if ((b & 1) != 0) {
                res = add(res, a);
            }
            a <<= 1;
            b >>>= 1;
        }
        return res;
    }

    public static int add(int a, int b) {
        int sum = a;
        while (b != 0) {
            sum = a ^ b;
            b = (a & b) << 1;
            a = sum;
        }
        return sum;
    }

    public static int negNum(int n) {
        return add(~n, 1);
    }

    public static int sub(int a, int b) {
        return add(a, negNum(b));
    }


    public static void main(String[] args) {
        System.out.println(add(2, 3));
        System.out.println(sub(2, 3));
        System.out.println(multi(2, 3));
        System.out.println(div(-6, 3));
    }
}

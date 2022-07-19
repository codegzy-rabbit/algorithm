package class10;

/**
 * 判断一个数是不是2的幂次方
 */

public class PowerNumber {
    public static boolean TwoPower(int n) {
        return (n & (n - 1)) == 0;
    }


    public static boolean FourPower(int n) {
        return TwoPower(n) && (n & 0x55555555) == n;
    }

    public static void main(String[] args) {
        System.out.println(TwoPower(4));
        System.out.println(FourPower(15));
    }
}

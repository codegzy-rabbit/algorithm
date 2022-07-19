package class08;

/**
 * 汉诺塔问题
 */

public class Hanoi {
    public static void main(String[] args) {
        print(3, "左", "右", "中");
    }

    public static void print(int n, String from, String to, String other) {
        if (n > 0) {
            print(n - 1, from, other, to);
            System.out.println("将" + n + "层从" + from + "放在" + to);
            print(n - 1, other, to, from);
        }
    }
}

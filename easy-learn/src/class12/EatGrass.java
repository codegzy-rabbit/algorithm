package class12;

/**
 * 两个人吃草，只能吃1，4，16，64...4^k的草
 * 一个吃过另一个吃，最后吃完的胜利，求谁会获胜
 */

public class EatGrass {

    public static String winner1(int N) {
        if (N < 5) {
            return (N == 0 || N == 2) ? "后手" : "先手";
        }

        int base = 1;
        while (base <= N) {
            if (winner1(N - base).equals("后手")) {
                return "先手";
            }
            if (base > N / 4) {
                break;
            }
            base *= 4;
        }
        return "后手";
    }

    public static String winner2(int N) {
        if (N % 5 == 0 || N % 5 == 2) {
            return "后手";
        } else return "先手";
    }

    public static void main(String[] args) {
        System.out.println(winner1(13));
        System.out.println(winner2(13));
    }

}

package class12;

/**
 * 一个f函数等概率返回1-5之间的数
 * 加工出返回1-7之间的数字的函数g
 */

public class RefortFuction {

    public static int one_five() {
        return (int) (Math.random() * 5) + 1;
    }

    public static int random01() {
        int res = 0;
        do {
            res = one_five();
        } while (res == 3);
        return res < 3 ? 0 : 1;
    }

    public static int one_seven() {
        int res = 0;
        do {
            res = (random01() << 2) + (random01() << 1) + random01();
        } while (res == 7);
        return res + 1;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(one_seven());
        }
    }
}

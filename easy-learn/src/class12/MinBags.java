package class12;

/**
 * 一个商店只给装6个和8个的袋子
 * 一个人去买N个苹果如果袋子能不多不少装下则买否则不买
 */

public class MinBags {

    public static int minbags1(int N) {
        if ((N & 1) == 1) {
            return -1;
        }
        int eightbags = N / 8;
        int rest = N % 8;
        while (eightbags >= 0 && rest < 24) {
            int sixbags = sixbag(rest);
            if (sixbags == 1) {
                return eightbags + rest / 6;
            }
            rest = N - 8 * (--eightbags);
        }
        return -1;
    }

    public static int sixbag(int N) {
        return N % 6 == 0 ? 1 : -1;
    }


    public static int minBags2(int N) {
        if (N < 18) {
            return (N == 6 || N == 8) ? 1 : (N == 12 || N == 14 || N == 16) ? 2 : -1;
        }
        return (N - 18) / 8 + 3;
    }

    public static void main(String[] args) {
//        for (int i = 0; i < 100; i++) {
//            System.out.println(i + " " + minbags(i));
//        }
        System.out.println(minbags1(20));
        System.out.println(minBags2(20));
    }

}

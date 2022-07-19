package class12;

/**
 * 给一个绳子打结，判断在指定长度 N 下能包含最多的节点
 */

public class KnotNumber {

    public static void main(String[] args) {
        int[] array = {2, 4, 7, 10, 13};
        System.out.println(maxKnot2(array, 8));
    }

    public static int maxKnot1(int[] array, int N) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int c = array[i] - N;
            if (c <= 0) {
                max = Math.max(max, i + 1);
            }
            for (int j = 0; j < array.length; j++) {
                if (array[j] >= c) {
                    max = Math.max(max, i - j + 1);
                }
            }
        }
        return max;
    }


    public static int maxKnot2(int[] array, int N) {
        int L = 0, R = 0;
        int max = Integer.MIN_VALUE;
        while (R < array.length - 1) {
            while (array[R] - array[L] <= N) {
                R++;
            }
            max = Math.max(max, R - L);
            L = R - 1;
        }
        return max;
    }

}

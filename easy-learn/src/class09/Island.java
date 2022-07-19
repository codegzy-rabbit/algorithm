package class09;

/**
 * 显示二维数组里有几个岛。1为岛，连起来的1为1个岛，斜着不算
 */

public class Island {
    public static void main(String[] args) {
        int[][] number = new int[][]{
                {0, 1, 0, 0, 1, 0},
                {1, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 1},
                {1, 0, 0, 1, 1, 0}
        };
        System.out.println(IslandNumber(number));
    }


    public static int IslandNumber(int[][] number) {
        if (number == null || number[0] == null) {
            return 0;
        }
        int res = 0;
        int M = number.length;  //行数
        int N = number[0].length;   //列数
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (number[i][j] == 1) {
                    res++;
                    inject(number, i, j, M, N);
                }
            }
        }
        return res;
    }

    public static void inject(int[][] number, int i, int j, int M, int N) {
        if (i < 0 || i >= M || j < 0 || j >= N || number[i][j] != 1) {
            return;
        }
        number[i][j] = 2;
        inject(number, i + 1, j, M, N);
        inject(number, i - 1, j, M, N);
        inject(number, i, j + 1, M, N);
        inject(number, i, j - 1, M, N);
    }
}

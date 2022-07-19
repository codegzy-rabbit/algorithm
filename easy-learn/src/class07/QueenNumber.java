package class07;

/**
 * N皇后问题
 */

public class QueenNumber {
    static boolean isVaild(int[] record, int i, int j) {
        for (int k = 0; k < i; k++) {
            if (j == record[k] || Math.abs(record[k] - j) == Math.abs(i - k)) {
                return false;
            }
        }
        return true;
    }

    static int process1(int i, int[] record, int n) {
        if (i == n) {
            return 1;
        }
        int result = 0;
        for (int j = 0; j < record.length; j++) {
            if (isVaild(record, i, j)) {
                record[i] = j;
                result += process1(i + 1, record, n);
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }

    static int num1(int n) {
        if (n < 1) {
            return 0;
        }

        int[] record = new int[n];
        return process1(0, record, n);
    }

    static int num2(int n) {
        if (n < 1 || n > 32) {
            return 0;
        }
        int limit = n == 32 ? -1 : (1 << n) - 1;
        return process2(limit, 0, 0, 0);
    }

    static int process2(int limit, int colLim, int leftLim, int rightLim) {
        if (colLim == limit) {
            return 1;
        }
        int pos = limit & (~(colLim | leftLim | rightLim));
        int mostRightPos = 0;
        int res = 0;
        while (pos != 0) {
            mostRightPos = pos & (~pos + 1);
            pos = pos - mostRightPos;
            res += process2(limit, colLim | mostRightPos, (leftLim | mostRightPos) << 1, (rightLim | mostRightPos) >>> 1);
        }
        return res;
    }
}

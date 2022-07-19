package class03;

/**
 * 桶排序
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] array =  {23,14,47,71,32};
        int digit = digit(array);
        bucketSort(array, 0, array.length - 1, digit);
        for (int i : array) {
            System.out.println(i);
        }
    }

    //计算最大数有几位，就是计算需要进出桶几次
    public static int digit(int[] array){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            max = Math.max(array[i], max);
        }
        int result = 0;
        while (max != 0){
            result++;
            max /= 10;
        }
        return result;
    }

    public static void bucketSort(int[] array, int L, int R, int digit){
        final int radix = 10;   //词频表范围
        int i = 0, j = 0;
        int[] bucket = new int[R - L + 1];  //辅助数组
        for (int d = 1; d <= digit; d++){   //进出桶的次数
            int[] count = new int[radix];
            for (i = L; i <= R; i++) {
                j = getDigit(array[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {   //计算词频表
                count[i] = count[i] + count[i - 1];
            }
            for (i = R; i >= L; i--){
                j = getDigit(array[i], d);
                bucket[count[j] - 1] = array[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                array[i] = bucket[j];
            }
        }
    }

    public static int getDigit(int x, int d){
        return (x / (int)Math.pow(10, d - 1) % 10);
    }
}

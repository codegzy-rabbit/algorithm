package class02;

/**
 * 小和问题:
 * 一个数比左边的小就算一个，求和
 */
public class SamllSum {
    public static void main(String[] args) {
        int[] array = {3,2,4,1,5};
        System.out.println(Sum(array, 0, array.length - 1));
    }
    public static int Sum(int[] array, int left, int right){
        if (left == right){
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return Sum(array, left, mid)
               + Sum(array, mid + 1, right)
               + Merge(array, left, mid, right);
    }

    public static int Merge(int[] array, int left, int mid, int right){
        int[] result = new int[right - left + 1];
        int small_Sum = 0;
        int i = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right){
            small_Sum += array[p1] < array[p2] ? array[p1] * (right - p2 + 1) : 0;
            result[i++] = array[p1] < array[p2] ?  array[p1++] : array[p2++];
        }
        while (p1 <= mid){
            result[i++] = array[p1++];
        }
        while (p2 <= right){
            result[i++] = array[p2++];
        }
        for (i = 0; i < result.length; i++) {
            array[left + i] = result[i];
        }
        return small_Sum;
    }
}

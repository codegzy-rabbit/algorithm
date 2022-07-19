package class02;

/**
 * 输出数组中的逆序对
 */
public class ReversePairs {
    public static void main(String[] args) {
        int[] array = {3,2,4,1,5};
        System.out.println(Sort(array, 0, array.length - 1));

    }

    public static int Sort(int[] array,int left, int right){
        if (left == right){
            return 0;
        }
        int mid = left + ((right - left) >> 1);
        return Sort(array, left, mid)
               + Sort(array, mid + 1, right)
               + Merge(array, left, mid, right);
    }

    public static int Merge(int[] array,int left, int mid, int right){
        int[] result = new int[right - left + 1];
        int i = 0;
        int pair = 0;
        int p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right){
            if (array[p1] > array[p2]){
                pair++;
            }
            result[i++] = array[p1] < array[p2] ? array[p2++] : array[p1++];
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
        return pair;
    }
}

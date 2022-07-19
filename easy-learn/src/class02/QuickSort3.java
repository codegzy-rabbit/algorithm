package class02;

/**
 * 快速排序3.0
 * 1.0和2.0版本的时间复杂度都是O(N^2)
 * 3.0版本时间复杂度是O(NlogN)
 */
public class QuickSort3 {
    public static void main(String[] args) {
        int[] array = {3,1,2,4,5,3,5};
        QuickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void QuickSort(int[] array, int left, int right){
        if (left < right){
            swap(array, left + (int) (Math.random() * (right - left + 1)), right);
            int[] partition = partition(array, left, right);
            QuickSort(array, left, partition[0] - 1);
            QuickSort(array, partition[1] + 1, right);
        }
    }

    public static int[] partition(int[] array,int left, int right){
        int less = left - 1;
        int more = right;
        while (left < more){
            if (array[left] < array[right]){
                swap(array, ++less, left++);
            }else if (array[left] > array[right]){
                swap(array, --more, left);
            }else {
                left++;
            }
        }
        swap(array, more, right);
        return new int[]{less + 1, more};
    }

    public static void swap(int[] array, int a, int b){
        if (a == b){
            return;
        }
        array[a] = array[a] ^ array[b];
        array[b] = array[a] ^ array[b];
        array[a] = array[a] ^ array[b];
    }
}

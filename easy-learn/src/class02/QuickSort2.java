package class02;

/**
 * 快速排序2.0
 * 在1.0的基础上将最右侧数的一组放在中间，左侧都比其小，右侧都比其大
 */

public class QuickSort2 {
    public static void main(String[] args) {
        int[] array = {3,1,2,4,5,3,5};
        Dived(array, 0 , array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void Dived(int[] array, int left, int right){
        if (left < right){
            int[] partition = partition(array, left, right);
            Dived(array, left, partition[0] - 1);
            Dived(array, partition[1] + 1, right);
        }
    }

    public static int[] partition(int[] array, int left, int right){
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

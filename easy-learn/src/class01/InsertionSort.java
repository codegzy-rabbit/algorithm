package class01;

/**
 * 插入排序
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] array = {3,1,4,5,2};
        for (int i : Insertion(array)) {
            System.out.println(i);
        }
    }

    public static int[] Insertion(int[] array){
        //第0个元素已经有序,则从第1个开始
        for (int i = 1; i < array.length; i++) {
            //从右向左看，前面已经有序，找到比其大的数跟其交换即可
            for (int j = i; j > 0 && array[j] < array[j - 1]; j--) {
                swap(array, j, j - 1);
            }
        }

        return array;
    }

    public static void swap(int[] array, int i, int j){
        if (i == j){
            return;
        }
        array[i] = array[i] ^ array[j];
        array[j] = array[i] ^ array[j];
        array[i] = array[i] ^ array[j];
    }
}

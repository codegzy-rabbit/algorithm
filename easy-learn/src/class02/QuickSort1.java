package class02;

/**
 * 快速排序1.0
 * 以最右边的数为基准分开数组
 * 分开后将最右边的数与比起刚大一点的数交换
 * 再将左右两侧递归使用上述方法（去最右侧为基准...）
 */
public class QuickSort1 {
    public static void main(String[] args) {
        int[] array = {3,1,2,4,5,3,5};
        QuickSort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void QuickSort(int[] array, int left, int right){
        if (left < right){
            int index = getIndex(array, left, right);
            QuickSort(array, left, index - 1);
            QuickSort(array, index + 1, right);
        }
    }

    public static int getIndex(int[] array, int left, int right){
        int less = left - 1;
        while (left < right){
            if (array[left] <= array[right]){
                swap(array, ++less, left++);
            }else {
                left++;
            }
        }
        swap(array, less + 1, right);
        return less + 1;
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

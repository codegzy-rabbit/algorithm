package class02;

/**
 * 求一个数组的最大值
 */
public class Recursive {
    public static void main(String[] args) {
        int[] array = {3,2,4,1,5};
        System.out.println(RecursiveMax(array, 0, array.length - 1));
    }
    public static int RecursiveMax(int[] array, int left, int right){
        if (left == right){
            return array[left];
        }
        int mid = left + ((right - left) >> 1);
        return Math.max(RecursiveMax(array, left, mid), RecursiveMax(array, mid + 1, right));
    }
}

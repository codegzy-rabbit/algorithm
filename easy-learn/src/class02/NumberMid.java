package class02;

/**
 * 设定一个num。将数组左侧的都小于等于num，右侧都大于num，中间的是num
 */
public class NumberMid {
    public static void main(String[] args) {
        int[] array = {2,5,1,4,3};
        MidNumber(array, 3);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void MidNumber(int[] array, int target){
        int small = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= target){
                swap(array, i, ++small);
            }
        }
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

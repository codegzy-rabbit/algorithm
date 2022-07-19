package class01;

public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {3,1,4,5,2};
        for (int i : Bubble(array)) {
            System.out.println(i);
        }
    }

    public static int[] Bubble(int[] array){
        //执行n-1次
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                //将相邻之间最大的数移到右侧交换
                if (array[j] > array[j + 1]){
                    swap(array, j, j + 1);
                }
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

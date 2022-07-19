package class01;

public class SelectionSort {
    public static void main(String[] args) {

        int[] array = {1,3,4,8,7,4,6,9,0};
        for (int i : Selection(array)) {
            System.out.println(i);
        }
    }

     public static int[] Selection(int[] array){
        //执行N-1轮循环
         for (int i = 0; i < array.length - 1; i++) {
             //标记最小数的位置
             int minIndex = i;
             for (int j = i +1; j < array.length; j++) {
                 if (array[minIndex] > array[j]){
                     //找到最小数据的位置
                     minIndex = j;
                 }
             }
             //跟最小数据位置的数交换
             swap(array, i, minIndex);
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

package class02;

public class DivedNumber {
    public static void main(String[] args) {
        int[] array = {2,3,5,5,1,4,3};
        Dived(array, 3);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void Dived(int[] array, int target){
        int less = -1;
        int greater = array.length;
        int i = 0;
        while (i < greater){
            if (array[i] < target){
                swap(array, i++, ++less);
            }else if (array[i] > target){
                swap(array, i, --greater);
            }else {
                i++;
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

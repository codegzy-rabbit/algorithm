package class02;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {3,2,4,1,5};
        Sort(array, 0, array.length - 1);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void Sort(int[] array, int left, int right){
        if (left == right){
            return;
        }
        int mid = left + ((right - left) >> 1);
        Sort(array, left, mid);
        Sort(array, mid + 1, right);
        Merge(array, left, mid, right);
    }

    public static void Merge(int[] array, int left, int mid, int right){
        int[] result = new int[right - left + 1];
        int i = 0;
        int p1 = left, p2 = mid + 1;
        while(p1 <= mid && p2 <= right){
            result[i++] = array[p1] <= array[p2] ? array[p1++] : array[p2++];
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
    }
}

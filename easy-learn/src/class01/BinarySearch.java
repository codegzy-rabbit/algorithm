package class01;

public class BinarySearch {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int target = 3;
        int mid = 0;
        int left = 0, right = array.length - 1;
        while (left < right){
            mid = (right - left) / 2 + left;
            if (target == array[mid]){
                System.out.println(array[mid]);
                return;
            }
            if (target < array[mid]){
                right = mid - 1;
            }
            if (target > array[mid]){
                left = mid + 1;
            }
        }
    }
}

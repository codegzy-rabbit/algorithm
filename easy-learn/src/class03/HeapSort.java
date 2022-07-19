package class03;

public class HeapSort {
    public static void main(String[] args) {
        int[] array =  {3,4,7,1,2};
        heapSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void heapSort(int[] array){
        if (array == null || array.length < 2){
            return;
        }
        int heapSize = array.length;
        for (int i = 0; i < array.length; i++) {
            headInsert(array, i);
        }
        swap(array, 0, --heapSize);
        while (heapSize > 0){
            heapify(array, 0, heapSize);
            swap(array, 0, --heapSize);
        }
    }

    //每插入一个值比父节点大就交换，直到不比父节点大时
    public static void headInsert(int[] array, int index){
        while (array[index] > array[(index - 1) / 2]){
            swap(array, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    //调整堆结构
    public static void heapify(int[] array, int index, int heapSize){
        int left = index * 2 + 1;
        while (left < heapSize){
            int largest = left + 1 < heapSize && array[left] < array[left + 1] ? left + 1 : left;
            largest = array[largest] > array[index] ? largest : index;
            if (largest == index){
                break;
            }
            swap(array, index, largest);
            index = largest;
            left = index * 2 + 1;

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

package class03;

import java.util.PriorityQueue;

/**
 * 一个几乎有序的数组，任意一个元素移动到有序位置
 * 需要移动的距离小于等于K
 */
public class K_DistanceSort {
    public static void main(String[] args) {
        int[] array = {3,4,6,7,1,9,5,6};
        distanceSort(array, 7);
        for (int i : array) {
            System.out.println(i);
        }
    }

    public static void distanceSort(int[] array, int K){
        //优先级队列     底层就是堆结构
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int index = 0;
        for (;index < Math.min(array.length, K); index++){
            heap.add(array[index]);
        }
        int i = 0;
        for (;index < array.length; i++, index++){
            heap.add(array[index]);
            array[i] = heap.poll();
        }
        while (!heap.isEmpty()){
            array[i++] = heap.poll();
        }
    }
}

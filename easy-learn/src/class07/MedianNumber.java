package class07;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 一个连续的数据流找到它的中位数
 */

public class MedianNumber {
    public static void main(String[] args) {
        int[] array = new int[]{3, 74, 9, 4, 6};
        System.out.println(Median(array));
    }

    static int Median(int[] array) {
        int cur = 0;
        PriorityQueue<Integer> minQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        PriorityQueue<Integer> maxQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i : array) {
            if (minQueue.isEmpty() && maxQueue.isEmpty()) {
                maxQueue.add(i);
                continue;
            }
            cur = i;
            if (cur <= maxQueue.peek()) {
                maxQueue.add(cur);
            } else {
                minQueue.add(cur);
            }
            if (minQueue.size() - maxQueue.size() == 2) {
                maxQueue.add(minQueue.poll());
            }
            if (maxQueue.size() - minQueue.size() == 2) {
                minQueue.add(maxQueue.poll());
            }
        }

        if ((minQueue.size() + maxQueue.size()) % 2 == 0) {
            cur = (minQueue.peek() + maxQueue.peek()) >>> 1;
        } else {
            cur = minQueue.peek();
        }
        return cur;
    }

}

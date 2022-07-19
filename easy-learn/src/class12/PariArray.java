package class12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个数组，求差值为K的去重数字对
 */

public class PariArray {

    public static List<List<Integer>> pairArray(int[] array, int K) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            set.add(array[i]);
        }
        ArrayList<List<Integer>> list = new ArrayList<>();
        for (Integer cur : set) {
            if (set.contains(cur + K)) {
                list.add(Arrays.asList(cur, cur + K));
            }
        }
        return list;
    }
}

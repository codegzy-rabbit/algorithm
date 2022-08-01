package array;

/**
 * @author GZY
 * @version 1.0
 * @date 2022/8/1 23:11
 */

import java.util.HashSet;
import java.util.Set;

/**
 * Contains Duplicate
 *
 * Q:Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
 *
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for(int i : nums){
            if(set.contains(i)){
                return true;
            }else set.add(i);
        }
        return false;
    }
}

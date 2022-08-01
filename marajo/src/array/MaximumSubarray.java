package array;

/**
 * @author GZY
 * @version 1.0
 * @date 2022/8/1 23:12
 */

/**
 * Maximum Subarray
 *
 * Q: Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * example1:
 *  Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int beforeSum = 0, maxSum = nums[0];
        for(int i : nums){
            beforeSum = Math.max(beforeSum + i, i);
            maxSum = Math.max(beforeSum, maxSum);
        }
        return maxSum;
    }

}

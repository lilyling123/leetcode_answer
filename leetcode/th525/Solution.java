package th525;

/**
 * Created by lily_ling on 2017/6/15.
 * <p>
 * <p>
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * <p>
 * Example 1:
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Example 2:
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 */
public class Solution {
    public int findMaxLength(int[] nums) {
        int zero = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
                zero++;
            }
        }

        return 0;
    }
}
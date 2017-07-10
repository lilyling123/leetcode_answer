package th16;

import java.util.Arrays;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        long min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                min = Math.abs(min - target) > Math.abs(sum - target) ? sum : min;
                if (sum > target) {
                    hi--;
                } else if (sum < target) {
                    lo++;
                } else {
                    return sum;
                }
            }
        }

        return (int) min;
    }

    public static void main(String[] args) {

    }
}
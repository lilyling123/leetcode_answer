package th628;

import java.util.Arrays;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int maximumProduct(int[] nums) {
        int res = 1;
        int n = nums.length;
        if (n < 3) {
            for (int i = 0; i < n; i++) {
                res *= nums[i];
            }
            return res;
        }

        Arrays.sort(nums);

        res *= nums[n - 1] * nums[n - 2] * nums[n - 3];
        res = Math.max(res, nums[0] * nums[1] * nums[n - 1]);
        return res;
    }
}
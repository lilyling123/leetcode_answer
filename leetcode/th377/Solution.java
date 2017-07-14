package th377;

import java.util.Arrays;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    private int[] memo;

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];

        dp[0] = 1;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

    public int combinationSum4_1(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        return helper(nums, target);

    }

    private int helper(int[] nums, int target) {
        if (memo[target] != -1) {
            return memo[target];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i])
                res += helper(nums, target - nums[i]);
        }
        memo[target] = res;

        return res;
    }

    public int combinationSum4_2(int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i])
                res += combinationSum4_2(nums, target - nums[i]);
        }


        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum4_2(new int[]{1, 2, 3}, 4));
    }
}
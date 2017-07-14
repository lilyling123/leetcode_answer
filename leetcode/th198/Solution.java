package th198;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    private int[] dp;

    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        dp = new int[nums.length];


        for (int i = 0; i < nums.length; i++) {
            if (i >= 2)
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            else if (i == 1) {
                dp[i] = Math.max(nums[i - 1], nums[i]);
            } else
                dp[i] = nums[i];
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{1, 3, 1, 1, 1}));
    }
}
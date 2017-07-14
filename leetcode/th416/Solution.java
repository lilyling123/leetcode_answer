package th416;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {

    public boolean canPartition(int[] nums) {

        if (nums == null || nums.length == 0) {
            return true;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) != 0)
            return false;

        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }

        return dp[sum];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1, 5, 11, 5}));
    }
}
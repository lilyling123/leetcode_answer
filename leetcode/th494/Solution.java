package th494;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    //动态规划
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;

        for (int i : nums) sum += i;

        if (s > sum || s < -sum) return 0;

        int[] dp = new int[2 * sum + 1];

        dp[0 + sum] = 1;

        for (int i = 0; i < nums.length; i++) {

            int[] next = new int[2 * sum + 1];

            for (int k = 0; k < 2 * sum + 1; k++) {

                if (dp[k] != 0) {

                    next[k + nums[i]] += dp[k];

                    next[k - nums[i]] += dp[k];
                }
            }
            dp = next;
        }
        return dp[sum + s];

    }

    private Map<String, Integer> memo;

    //递归加上记忆化搜索
    public int findTargetSumWays2(int[] nums, int S) {

        memo = new HashMap<>();

        return findTargetSumWays(nums, S, 0);
    }

    private int findTargetSumWays(int[] nums, int s, int idx) {
        //记录的必须是独一无二的东西 由于这里的s可能会成为负数，因此不应当使用
        String encodeString = idx + "->" + s;
        if (memo.containsKey(encodeString)) {
            return memo.get(encodeString);
        }

        if (s == 0 && idx >= nums.length) {
            return 1;
        }
        if (idx >= nums.length) {
            return 0;
        }


        int res = 0;
        res += findTargetSumWays(nums, s - nums[idx], idx + 1);
        res += findTargetSumWays(nums, s + nums[idx], idx + 1);
        memo.put(encodeString, res);

        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 1));
    }
}
package th343;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    private int[] dp;

    public int integerBreak(int n) {

        dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(Math.max(dp[i - j], i - j) * j, dp[i]);
            }
        }


        return dp[n];
    }

    public static void main(String[] args) {

        System.out.println(new Solution().integerBreak(10));
    }


}
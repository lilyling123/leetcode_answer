package th64;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid.length == 0)
            return 0;

        int[] dp = new int[grid[0].length];


        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[j] = grid[i][j];
                    } else {
                        dp[j] = dp[j - 1] + grid[i][j];
                    }
                } else if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[grid[0].length - 1];
    }

    public static void main(String[] args) {

        System.out.println(new Solution().minPathSum(new int[][]{
                {0}
        }));
    }
}
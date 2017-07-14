package th322;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    private int[][] memo;

    //递归的写法
    private int search(int idx, int amount, int[] coins) {
        if (amount == 0)
            return 0;
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (idx >= coins.length) {
            return Integer.MAX_VALUE;
        }

        if (memo[idx][amount] != 0) {
            return memo[idx][amount];
        }

        int a = search(idx, amount - coins[idx], coins);
        int b = search(idx + 1, amount, coins);
        if (a >= b || a == Integer.MAX_VALUE) {
            memo[idx][amount] = b;
        } else {
            memo[idx][amount] = a + 1;
        }

        return memo[idx][amount];
    }

    public int coinChange2(int[] coins, int amount) {
        memo = new int[coins.length + 1][amount + 1];
        int res = search(0, amount, coins);
        if (res < Integer.MAX_VALUE)
            return res;
        return -1;
    }

    //注意设置不可达的点
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0)
            return 0;

        int[] dp = new int[amount + 1];
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && dp[i - coins[j]] != Integer.MAX_VALUE)
                    dp[i] = Integer.min(dp[i], 1 + dp[i - coins[j]]);
            }
        }

        if (dp[amount] == Integer.MAX_VALUE)
            return -1;
        else
            return dp[amount];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().coinChange2(new int[]{1, 2}, 3));
    }
}
package th474;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        dp[0][0] = 0;
        for (String str : strs) {
            int zero = 0;
            int one = 0;

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '0') {
                    zero++;
                } else {
                    one++;
                }
            }
            int[][] newDp = new int[m + 1][n + 1];

            for (int i = 0; i < newDp.length; i++) {
                for (int j = 0; j < newDp[i].length; j++) {
                    if (i >= zero && j >= one) {
                        newDp[i][j] = Math.max(dp[i - zero][j - one] + 1, dp[i][j]);
                    } else {
                        newDp[i][j] = dp[i][j];
                    }

                }
            }
            dp = newDp;

        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ,");
            }
            System.out.println();
        }

        return dp[m][n];
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        int[][] max = new int[m + 1][n + 1];
        for (String str : strs) {
            int ones = 0, zeros = 0;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == '0') zeros++;
                else ones++;
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    max[i][j] = Math.max(max[i][j], 1 + max[i - zeros][j - ones]);
                }
            }
        }
        return max[m][n];
    }

    public static void main(String[] args) {

        System.out.println(new Solution().findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}
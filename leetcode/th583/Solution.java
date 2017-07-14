package th583;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.equals(""))
            return word2.length();
        if (word2.equals(""))
            return word1.length();

        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
            }
        }

        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance("food", "money"));

    }
}
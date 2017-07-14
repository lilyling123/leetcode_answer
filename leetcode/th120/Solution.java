package th120;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);

            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(new Solution().minimumTotal(triangle));
    }
}
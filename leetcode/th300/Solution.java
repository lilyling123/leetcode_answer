package th300;

import java.util.Arrays;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return nums.length;
        int[] memo = new int[nums.length + 1];

        int[] min = new int[nums.length + 1];

        int path = 1;

        Arrays.fill(min, Integer.MAX_VALUE);

        Arrays.fill(memo, 1);

        min[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {

            for (int j = path; j >= 1; j--) {

                if (nums[i] > min[j]) {

                    memo[i] = max(memo[i], j + 1);

                }
            }
            min[memo[i]] = Math.min(min[memo[i]], nums[i]);

            path = max(path, memo[i]);

        }
        int res = 1;
        for (int i = 0; i < memo.length; i++) {
            res = max(res, memo[i]);
        }
        return res;
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    public static void main(String[] args) {

        int i = new Solution().lengthOfLIS(new int[]{-2, -1});

        System.out.println(i);
    }
}
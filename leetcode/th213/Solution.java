package th213;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    private int[] dp1;


    //笨方法
    public int rob(int[] nums) {
        if (nums.length == 0)
            return 0;
        if (nums.length == 1) {
            return nums[0];
        }

        dp1 = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            if (i >= 2)
                dp1[i] = Math.max(nums[i] + dp1[i - 2], dp1[i - 1]);
            else if (i == 1) {
                dp1[i] = Math.max(nums[i - 1], nums[i]);
            } else
                dp1[i] = nums[i];
        }
        int res = dp1[nums.length - 2];
        dp1[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            if (i >= 2)
                dp1[i] = Math.max(nums[i] + dp1[i - 2], dp1[i - 1]);
            else if (i == 1) {
                dp1[i] = nums[i];
            }
        }


        return Math.max(res, dp1[nums.length - 1]);
    }



    public static void main(String[] args) {

        System.out.println(new Solution().rob(new int[]{2, 1, 1, 2}));
    }
}
package th414;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int thirdMax(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        long m = Long.MIN_VALUE, n = Long.MIN_VALUE, res = Long.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (m < nums[i]) {
                res = n;
                n = m;
                m = nums[i];
            } else if (n < nums[i] && m != nums[i]) {
                res = n;
                n = nums[i];
            } else if (res < nums[i] && m != nums[i] && n != nums[i]) {
                res = nums[i];
            }
        }
        if (res == Long.MIN_VALUE)
            return (int) m;

        return (int) res;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().thirdMax(new int[]{1, 2, 2, 5, 3, 5}));
    }
}
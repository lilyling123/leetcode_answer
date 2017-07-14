package th209;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int res = nums.length + 1;
        int sum = 0;
        int lo = 0;
        int hi = 0;
        while (true) {
            if (sum >= s) {
                res = res > hi - lo ? hi - lo : res;
                sum -= nums[lo];
                lo++;
            } else if (sum < s) {
                if (hi >= nums.length)
                    break;
                sum += nums[hi];
                hi++;

            }
        }
        res = res == nums.length + 1 ? 0 : res;
        return res;
    }

    public static void main(String[] args) {
        int res = new Solution().minSubArrayLen(3, new int[]{1, 1});
        System.out.println(res);
    }
}
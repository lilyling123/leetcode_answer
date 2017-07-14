package th581;

import java.util.Arrays;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] temp = nums.clone();
        int lo = -1, hi = nums.length;
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            if (nums[i] != temp[i]) {
                lo = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] != temp[i]) {
                hi = i;
                break;
            }
        }
        if (lo == -1) {
            return 0;
        }
        return hi - lo + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
package th75;

import java.util.Arrays;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 1)
            return;
        int zero = 0;
        int one = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            } else if (nums[i] == 1) {
                one++;
            }
        }
        int i = 0;
        for (; i < zero; i++) {
            nums[i] = 0;
        }
        for (; i < zero + one; i++) {
            nums[i] = 1;
        }
        for (; i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        int[] ins = new int[]{2, 2, 1, 1, 0, 0};
        new Solution().sortColors(ins);

        System.out.println(Arrays.toString(ins));

    }
}
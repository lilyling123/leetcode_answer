package th26;

import java.util.Arrays;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        int lo = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[lo]) {
                nums[++lo] = nums[i];
            }
        }
        return lo + 1;
    }

    public static void main(String[] args) {
        int[] ins = new int[]{1, 1, 2};
        int a = new Solution().removeDuplicates(ins);
        System.out.println(Arrays.toString(ins));
    }
}
package th283;

import java.util.Arrays;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public void moveZeroes(int[] nums) {

        int zeroIndex = 0;
        int index = 0;

        while (index < nums.length) {
            if (nums[index] != 0) {

                if (nums[zeroIndex] == 0) {
                    nums[zeroIndex] = nums[index];
                    nums[index] = 0;
                }
                zeroIndex++;
            }
            index++;
        }
    }

    public static void main(String[] args) {
        int[] ins = new int[]{0, 1};

        new Solution().moveZeroes(ins);
        System.out.println(Arrays.toString(ins));
    }
}
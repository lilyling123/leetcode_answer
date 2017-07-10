package th80;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1 || nums.length == 2) {
            return nums.length;
        }
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }

    public static void main(String[] args) {

    }
}
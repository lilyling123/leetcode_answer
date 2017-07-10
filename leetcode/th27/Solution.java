package th27;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int lo = 0;
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != val)
                nums[lo++] = nums[i];
        return lo;
    }
}
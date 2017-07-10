package th35;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {

        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hi = mid - 1;

            } else if (nums[mid] < target) {
                lo = mid + 1;
            }
        }
        if (hi < 0)
            return 0;
        if (nums[hi] < target)
            return hi + 1;
        return hi;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().searchInsert(new int[]{1, 3, 5, 6}, 4));
    }
}
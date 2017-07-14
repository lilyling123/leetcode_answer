package th287;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int slow = n;
        int fast = n;

        do {
            slow = nums[slow - 1];
            fast = nums[nums[fast - 1] - 1];
        } while (slow != fast);

        slow = n;

        while (slow != fast) {
            slow = nums[slow - 1];
            fast = nums[fast - 1];
        }
        return slow;
    }

    public static void main(String[] args) {
        new Solution().findDuplicate(new int[]{1, 1, 2, 3, 5, 4});
    }
}
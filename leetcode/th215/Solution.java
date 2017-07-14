package th215;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return Integer.MAX_VALUE;
        return nums[assist(nums, 0, nums.length - 1, nums.length - k)];
    }

    private static int assist(int[] nums, int lo, int hi, int k) {

        if (lo > hi) throw new RuntimeException();
        if (lo == hi) return lo;

        int part = partition(nums, lo, hi);
        if (part == k) {
            return part;
        } else if (part > k) {
            return assist(nums, lo, part - 1, k);
        } else {
            return assist(nums, part + 1, hi, k);
        }
    }

    private static int partition(int[] nums, int lo, int hi) {

        int num = nums[lo];
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (nums[--j] > num) {
                if (j <= lo)
                    break;
            }
            while (nums[++i] < num) {
                if (i >= hi)
                    break;
            }
            if (i >= j)
                break;
            swap(nums, i, j);
        }
        swap(nums, i, j);
        return j;
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}
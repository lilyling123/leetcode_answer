package th189;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public void rotate(int[] nums, int k) {
        if (nums.length == 0 || nums.length == 1)
            return;
        if (k == 0)
            return;
        int n = nums.length;
        k %= n;
        int[] temp = new int[k];
        System.arraycopy(nums, n - k, temp, 0, k);

        for (int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = temp[i];
        }

        return;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1, 2};

        new Solution().rotate(a, 3);

        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
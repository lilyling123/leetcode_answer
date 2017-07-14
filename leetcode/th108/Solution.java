package th108;

import Utils.TreeNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        TreeNode root = sortedArrayToBST(nums, 0, nums.length - 1);

        return root;

    }

    private TreeNode sortedArrayToBST(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        if (lo == hi)
            return new TreeNode(nums[lo]);
        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(nums[mid]);

        node.left = sortedArrayToBST(nums, lo, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, hi);

        return node;
    }
}
package th230;

import Utils.TreeNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            throw new RuntimeException();

        int count = countTreeNumber(root.left) + 1;

        if (k > count) {
            return kthSmallest(root.right, k - count - 1);
        } else if (k < count) {
            return kthSmallest(root.left, k);
        } else {
            return root.val;
        }
    }

    private int countTreeNumber(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + countTreeNumber(node.left) + countTreeNumber(node.right);
    }
}
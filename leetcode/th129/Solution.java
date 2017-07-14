package th129;

import Utils.TreeNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int sumNumbers(TreeNode root) {
        return sum(root, 0);
    }

    private static int sum(TreeNode node, int s) {
        if (node == null)
            return 0;
        int sum = s * 10 + node.val;
        if (node.left == null && node.right == null) return sum;
        return sum(node.left, sum) + sum(node.right, sum);
    }
}
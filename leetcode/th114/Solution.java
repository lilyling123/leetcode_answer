package th114;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    List<TreeNode> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        preOrder(root);
        TreeNode node = root;
        for (TreeNode t : list) {
            root.right = new TreeNode(t.val);
            root = root.right;
        }
        root = node.right;

        return;
    }

    public void preOrder(TreeNode root) {
        if (root == null)
            return;

        preOrder(root.left);
        list.add(root);
        preOrder(root.right);

    }

    public static void main(String[] args) {
        new Solution().flatten(new TreeNode(0));
    }
}
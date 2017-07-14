package th257;

import Utils.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new LinkedList<>();

        return help(root, root.val + "", new LinkedList<>());
    }

    private List<String> help(TreeNode root, String s, LinkedList list) {
        if (root.left == null && root.right == null) {
            list.add(s);
        }

        if (root.left != null) {
            help(root.left, s + "->" + root.left.val, list);
        }
        if (root.right != null) {
            help(root.right, s + "->" + root.right.val, list);
        }
        return list;
    }
}
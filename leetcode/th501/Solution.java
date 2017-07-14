package th501;

import Utils.TreeNode;

import java.util.*;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    int maxOccor = 0;
    TreeNode pre = null;
    int curMax = 0;

    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return new int[0];
        help(root, list);
        if (curMax == maxOccor) {
            list.add(pre.val);
        }
        if (curMax > maxOccor) {
            list.clear();
            list.add(pre.val);
            maxOccor = curMax;
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }

    public void help(TreeNode root, List<Integer> list) {
        if (root == null) return;
        if (root.left != null) help(root.left, list);
        if (pre == null) {
            curMax = 1;
        } else {
            if (root.val == pre.val) curMax++;
            else {
                if (curMax == maxOccor) {
                    list.add(pre.val);
                }
                if (curMax > maxOccor) {
                    list.clear();
                    list.add(pre.val);
                    maxOccor = curMax;
                }
                curMax = 1;
            }
        }
        pre = root;
        if (root.right != null) help(root.right, list);

    }
}
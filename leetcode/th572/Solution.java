package th572;

import Utils.TreeNode;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null)
            return false;
        if (t == null)
            return false;

        boolean flag = false;
        if (s.val == t.val) {
            flag = _isSubtree(s.right, t.right) && _isSubtree(s.left, t.left);
        }

        flag = flag || isSubtree(s.left, t) || isSubtree(s.right, t);

        return flag;


    }

    private boolean _isSubtree(TreeNode s, TreeNode t) {
        if (s == null && t == null)
            return true;
        if (s == null)
            return false;
        if (t == null)
            return false;

        if (s.val == t.val)
            return _isSubtree(s.right, t.right) && _isSubtree(s.left, t.left);
        else
            return false;
    }

    public static void main(String[] args) {
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);
        s.right = new TreeNode(3);
        System.out.println(new Solution().isSubtree(s, t));
    }
}
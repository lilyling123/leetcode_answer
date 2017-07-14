package th113;

import Utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> results = new LinkedList<>();

        help(root, sum, new ArrayList<>(), results);
        return results;
    }

    private void help(TreeNode root, int sum, List<Integer> list, List<List<Integer>> results) {
        if (root == null) return;
        if (root.left == null && root.right == null
                && root.val == sum) {
            List<Integer> temp = new ArrayList<Integer>(list);
            temp.add(root.val);
            results.add(temp);
        }
        list.add(root.val);
        help(root.left, sum - root.val, list, results);
        help(root.right, sum - root.val, list, results);
        list.remove(list.size() - 1);

    }
}
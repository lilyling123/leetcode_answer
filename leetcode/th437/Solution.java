package th437;

import Utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return pathSum(root.left, sum) + pathSum(root.right, sum) + help(root, sum);


    }

    private int help(TreeNode node, int sum) {
        if (node == null) return 0;
        int num = sum - node.val;
        return (num == 0 ? 1 : 0) +
                help(node.left, num) + help(node.right, num);

    }

    public int pathSum2(TreeNode root, int sum) {
        Map<Integer, Integer> sums = new HashMap<>();
        sums.put(0, 1);
        return path(root, sum, 0, sums);
    }

    public int path(TreeNode root, int sum, int currSum, Map<Integer, Integer> sums) {
        if (root == null) return 0;
        currSum += root.val;
        int result = sums.getOrDefault(currSum - sum, 0);
        sums.put(currSum, sums.getOrDefault(currSum, 0) + 1);

        result += path(root.left, sum, currSum, sums) + path(root.right, sum, currSum, sums);
        sums.put(currSum, sums.get(currSum) - 1);
        return result;
    }

}
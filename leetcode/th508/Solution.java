package th508;

import Utils.TreeNode;

import java.util.*;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        findFrequentTreeSum(root, map);

        Set<Map.Entry<Integer, Integer>> set = new HashSet<>();

        set.addAll(map.entrySet());

        List<Integer> list = new ArrayList<>();
        int frequency = 0;
        for (Map.Entry<Integer, Integer> entry : set) {
            if (entry.getValue() > frequency) {
                list.clear();
                list.add(entry.getKey());
                frequency = entry.getValue();
            } else if (entry.getValue() == frequency) {
                list.add(entry.getKey());
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private int findFrequentTreeSum(TreeNode root, Map<Integer, Integer> map) {
        if (root == null)
            return 0;
        int left = findFrequentTreeSum(root.left, map);
        int right = findFrequentTreeSum(root.right, map);

        int sum = root.val + left + right;
        map.put(sum, map.getOrDefault(sum, 0) + 1);

        return sum;

    }

    public static void main(String[] args) {

    }
}
package th491;

import java.util.*;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        helper(new LinkedList<>(), 0, nums, res);
        return res;
    }

    private void helper(LinkedList<Integer> list, int index, int[] nums, List<List<Integer>> res) {
        if (list.size() > 1)
            res.add(new ArrayList<>(list));

        Set<Integer> used = new HashSet<>();

        for (int i = index; i < nums.length; i++) {

            if (used.contains(nums[i])) {
                continue;
            }
            if (list.size() == 0 || list.peekLast() <= nums[i]) {
                list.add(nums[i]);

                used.add(nums[i]);

                helper(list, i + 1, nums, res);

                list.remove(list.size() - 1);

            }

        }
    }

    public List<List<Integer>> findSubsequences2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();


        Arrays.sort(nums);


        dfs(nums, 0, new ArrayList<>(), res);


        return res;
    }

    private void dfs(int[] nums, int index, List<Integer> list, List<List<Integer>> res) {
        if (index >= nums.length)
            return;

        list.add(nums[index]);

        if (list.size() >= 2) {
            res.add(new ArrayList<>(list));
        }

        dfs(nums, index + 1, list, res);

        list.remove(list.size() - 1);
        dfs(nums, index + 1, list, res);

    }

    public static void main(String[] args) {
        System.out.println(new Solution().findSubsequences(new int[]{4, 6, 7, 7}));
    }
}
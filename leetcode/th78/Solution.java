package th78;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            subsets(nums, i, new ArrayList(), 0);
        }

        return result;
    }

    private void subsets(int[] nums, int k, List<Integer> list, int lo) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = lo; i < nums.length; i++) {
                list.add(nums[i]);

                subsets(nums, k, list, i + 1);

                list.remove(list.size() - 1);

        }

    }

    public static void main(String[] args) {

        System.out.println(new Solution().subsets(new int[]{1, 2, 3}));
    }
}
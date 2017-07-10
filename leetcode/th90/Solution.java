package th90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            subsetsWithDup(nums, i, 0, new ArrayList());
        }


        return result;
    }

    private void subsetsWithDup(int[] nums, int m, int n, List<Integer> list) {
        if (list.size() == m) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = n; i < nums.length; i++) {
            if (i > n && nums[i - 1] == nums[i]) {
                continue;
            }
            list.add(nums[i]);
            subsetsWithDup(nums, m, i + 1, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().subsetsWithDup(new int[]{1, 2, 2}));
    }
}
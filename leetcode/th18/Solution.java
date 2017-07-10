package th18;

import java.util.*;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        Map<Integer, List<Integer>> memo = new HashMap<>();


        for (int i = 0; i < nums.length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || (j > 1 && nums[j] != nums[j - 1])) {
                        int lo = j + 1, hi = nums.length - 1, sum = target - nums[i] - nums[j];
                        while (lo < hi) {
                            if (nums[lo] + nums[hi] == sum) {
                                res.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                                while (lo < hi && nums[lo] == nums[lo + 1]) lo++;
                                while (lo < hi && nums[hi] == nums[hi - 1]) hi--;
                                lo++;
                                hi--;
                            } else if (nums[lo] + nums[hi] < sum)
                                lo++;
                            else
                                hi--;
                        }
                    }
                }

            }
        }
        return res;

    }
}
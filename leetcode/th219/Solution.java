package th219;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k)
                set.remove(nums[i - k - 1]);
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }
}
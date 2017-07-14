package th217;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }
}
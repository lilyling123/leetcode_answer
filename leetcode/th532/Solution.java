package th532;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (k == 0) {
                if (entry.getValue() >= 2) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }


        }


        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findPairs(new int[]{1, 1, 1, 2, 2}, 0));
    }
}
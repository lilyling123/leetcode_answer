package th349;

import java.util.*;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> result = new HashSet<>();
        for (int j = 0; j < nums2.length; j++) {
            if (set1.contains(nums2[j])) {
                result.add(nums2[j]);
            }
        }
        int[] num = new int[result.size()];
        int i = 0;
        for (Integer in : result) {
            num[i++] = in;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})[0]);
    }
}
package th88;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n - 1;
        int i = m - 1;
        int j = n - 1;
        while (i > -1 && j > -1) nums1[len--] = nums1[i] > nums2[j] ? nums1[i--] : nums1[j--];
        while (j > -1) nums1[len--] = nums2[j--];
    }
}
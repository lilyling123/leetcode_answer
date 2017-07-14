package th454;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int sum = A[i] + B[j];
                if (map.get(sum) == null) {
                    map.put(sum, 1);
                } else {
                    map.put(sum, map.get(sum) + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                sum = 0 - sum;
                if (map.get(sum) != null) {
                    res += map.get(sum);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
}
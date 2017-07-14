package th447;

import java.util.*;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i != j) {
                    int d = getDistance(points[i], points[j]);
                    map.put(d, map.getOrDefault(d, 0) + 1);
                }
            }
            for (int val : map.values()) {
                res += val * (val - 1);
            }
            map.clear();
        }

        return res;
    }

    private int getDistance(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];

        return dx * dx + dy * dy;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
    }
}
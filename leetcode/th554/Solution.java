package th554;

import java.util.*;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();

        for (List<Integer> list : wall) {
            int sum = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                sum += list.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

        }
        int res = 0;
        int max = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                res = entry.getKey();
            }

        }
        return wall.size() - max;
    }

    public static void main(String[] args) {

        List<List<Integer>> wall = new ArrayList<>();

        wall.add(Arrays.asList(new Integer[]{1, 1}));
        wall.add(Arrays.asList(new Integer[]{2}));
        wall.add(Arrays.asList(new Integer[]{1, 1}));
        System.out.println(new Solution().leastBricks(wall));
    }
}
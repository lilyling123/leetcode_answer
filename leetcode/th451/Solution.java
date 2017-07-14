package th451;

import java.util.*;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public String frequencySort(String s) {
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : cs) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        Set<Map.Entry<Character, Integer>> set = new TreeSet<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                if (o1.getValue() > o2.getValue())
                    return -1;
                return 1;
            }
        });

        set.addAll(map.entrySet());
        int i = 0;
        for (Map.Entry<Character, Integer> entry : set) {
            int N = entry.getValue();
            char c = entry.getKey();
            while (N-- > 0) {
                cs[i] = c;
                i++;
            }
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().frequencySort("Aabb"));
    }
}
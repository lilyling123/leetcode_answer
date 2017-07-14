package th290;

import java.util.*;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean wordPattern2(String pattern, String str) {
        if (str == null || str.isEmpty()) return false;

        str = str.trim();

        String strs[] = str.split(" ");

        if (strs.length != pattern.length()) return false;

        Map<Integer, String> m = new HashMap<>();

        for (int i = 0; i < pattern.length(); ++i) {

            Integer k = Integer.valueOf(pattern.charAt(i));

            if (!m.containsKey(k)) {
                if (m.containsValue(strs[i])) return false;
                m.put(k, strs[i]);
            } else {
                String v = m.get(k);
                if (!v.equals(strs[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean wordPattern(String pattern, String str) {

        if (pattern.equals("")) return false;

        String[] p = pattern.split("");
        String[] strs = str.split(" ");

        if (p.length != strs.length) return false;

        Map<String, Integer> map = new HashMap<>();
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();
        for (int i = 0; i < p.length; i++) {
            set1.add(p[i]);
            set2.add(strs[i]);
            String s = p[i] + strs[i];
            if (!map.containsKey(s))
                map.put(s, 1);
            else
                map.put(s, map.get(s));
        }

        return set1.size() == map.keySet().size() && set1.size() == set2.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordPattern("aaba", "dog cat cat dog"));
    }
}
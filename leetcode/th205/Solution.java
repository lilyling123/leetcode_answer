package th205;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length())
            return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            if (map.get(cs[i]) == null) {
                if (map.containsValue(ct[i]))
                    return false;
                map.put(cs[i], ct[i]);
            } else {
                char c = map.get(cs[i]);
                if (c != ct[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("paper", "title"));
    }
}
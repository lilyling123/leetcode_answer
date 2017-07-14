package th242;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        for (char c : s.toCharArray())
            map[c - 'a']++;
        for (char c : t.toCharArray())
            map[c - 'a']--;
        for (int count : map)
            if (count != 0) return false;
        return true;
    }
}
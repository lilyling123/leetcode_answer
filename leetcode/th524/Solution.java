package th524;

import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public String findLongestWord(String s, List<String> d) {
        String longest = "";

        for (String s1 : d) {
            char[] chars = s1.toCharArray();
            int i = 0;
            for (char c : s.toCharArray())
                if (i < chars.length && c == chars[i]) i++;

            if (i == chars.length && chars.length >= longest.length())
                if (chars.length > longest.length() || s1.compareTo(longest) < 0)
                    longest = s1;
        }

        return longest;
    }
}
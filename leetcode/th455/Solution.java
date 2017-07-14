package th455;

import java.util.Arrays;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0;
        for (int j = 0; j < s.length && i < g.length; j++) {
            if (s[j] >= g[i]) i++;
        }
        return i;
    }
}
package th345;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {


    public String reverseVowels(String s) {
        int lo = 0, hi = s.length() - 1;
        char[] target = s.toCharArray();
        boolean[] chars = new boolean[256];
        chars['a'] = true;
        chars['e'] = true;
        chars['o'] = true;
        chars['i'] = true;
        chars['u'] = true;
        chars['A'] = true;
        chars['E'] = true;
        chars['I'] = true;
        chars['O'] = true;
        chars['U'] = true;

        while (lo <= hi) {

            while (!chars[target[lo]]) {
                lo++;
                if (lo >= hi)
                    break;
            }
            while (!chars[target[hi]]) {
                hi--;
                if (hi <= lo)
                    break;
            }
            if (lo >= hi)
                break;
            char c = target[lo];
            target[lo] = target[hi];
            target[hi] = c;
            lo++;
            hi--;
        }
        return new String(target);
    }

    public static void main(String[] args) {

        System.out.println(new Solution().reverseVowels("leetcode"));
    }
}
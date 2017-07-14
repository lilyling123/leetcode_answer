package th521;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());

    }
}
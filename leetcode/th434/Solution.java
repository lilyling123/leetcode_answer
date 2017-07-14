package th434;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int countSegments(String s) {
        if(s.equals(""))
            return 0;

        String[] split = s.split("\\s+");
        int res = 0;
        for (String s1 : split) {
            if (!s1.equals(""))
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSegments("    foo    bar"));
    }
}
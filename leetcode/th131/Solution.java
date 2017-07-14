package th131;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();

        partition(s, result, new ArrayList<>());

        return result;
    }

    private void partition(String s, List<List<String>> result, List es) {
        if (s.equals("")) {
            result.add(es);
            return;
        }
        int len = s.length();

        for (int i = 1; i <= len; i++) {

            String sub = s.substring(0, i);
            boolean flag = isPalindrome(sub);

            if (flag) {
                List<String> list = new ArrayList<>(es);
                list.add(sub);
                partition(s.substring(i), result, list);
            }

        }

    }

    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int lo = 0, hi = chars.length - 1;
        while (lo < hi) {
            if (chars[lo] == chars[hi]) {
                lo++;
                hi--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("abcba"));

    }


}
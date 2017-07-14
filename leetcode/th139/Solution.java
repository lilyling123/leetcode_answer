package th139;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {


    private boolean memo[];

    //递归和记忆化搜索
    public boolean wordBreak2(String s, List<String> wordDict) {
        if (s.equals(""))
            return true;
        if (wordDict.size() == 0)
            return false;
        memo = new boolean[s.length() + 1];
        memo[0] = true;

        return wordBreak2(s, wordDict, 0, 1);
    }

    private boolean wordBreak2(String s, List<String> wordDict, int lo, int hi) {
        if (hi == s.length() && wordDict.contains(s.substring(lo, hi))) {
            return true;
        }
        if (hi > s.length()) {
            return false;
        }
        if (memo[hi])
            return memo[hi];
        String sub = s.substring(lo, hi);
        if (wordDict.contains(sub)) {
            //两种选择 加上或者不加上
            memo[hi] = wordBreak2(s, wordDict, hi, hi + 1)
                    || wordBreak2(s, wordDict, lo, hi + 1);
        } else {
            memo[hi] = wordBreak2(s, wordDict, lo, hi + 1);
        }

        return memo[hi];
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.equals(""))
            return true;
        if (wordDict.size() == 0)
            return false;

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j])
                    dp[i] = wordDict.contains(s.substring(j, i));
                //如果找到了，就撤退
                if (dp[i])
                    break;
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        String[] ss = new String[]{"a", "ab"};
        list.addAll(Arrays.asList(ss));


        System.out.println(new Solution().wordBreak("aba", list));
    }
}
package th17;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    private static String[] ss = new String[256];

    public List<String> letterCombinations(String digits) {

        List<String> res = new ArrayList<>();
        if (digits == null || "".equals(digits)) return res;
        ss['2'] = "abc";
        ss['3'] = "def";
        ss['4'] = "ghi";
        ss['5'] = "jkl";
        ss['6'] = "mno";
        ss['7'] = "pqrs";
        ss['8'] = "tuv";
        ss['9'] = "wxyz";
        combination("", digits.toCharArray(), 0, res);
        return res;
    }

    private void combination(String s, char[] digits, int i, List<String> result) {
        if (i == digits.length) {
            result.add(s);
            return;
        }
        char[] chars = ss[digits[i]].toCharArray();

        for (int j = 0; j < chars.length; j++) {

            combination(s + chars[j], digits, i + 1, result);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }

}
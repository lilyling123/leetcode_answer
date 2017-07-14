package th336;

import java.util.*;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer[], String> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[i].charAt(0) == words[j].charAt(words[j].length() - 1))
                    map.put(new Integer[]{i, j}, words[i] + words[j]);
                if (words[j].charAt(0) == words[i].charAt(words[i].length() - 1))
                    map.put(new Integer[]{j, i}, words[j] + words[i]);
            }
        }

        for (Map.Entry<Integer[], String> entry : map.entrySet()) {

            if (isPalindrome(entry.getValue())) {
                res.add(Arrays.asList(entry.getKey()));
            }

        }
        return res;
    }

    private boolean isPalindrome(String str) {
        int lo = 0, hi = str.length() - 1;
        while (lo < hi) {
            if (str.charAt(lo++) != str.charAt(hi--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().palindromePairs(new String[]{
                "abcd", "dcba", "lls", "s", "sssll"
        }));

    }
}
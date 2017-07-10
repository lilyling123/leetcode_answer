package th76;

import java.util.HashMap;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if (map.get(s.charAt(right)) >= 0) {
                    count++;
                }
                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    if (map.containsKey(s.charAt(left))) {
                        map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                        if (map.get(s.charAt(left)) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if (minLen > s.length()) {
            return "";
        }

        return s.substring(minLeft, minLeft + minLen);
    }

    public String minWindow2(String s, String t) {
        if(t==null||s==null) return "";
        int beg = 0;
        int end = 0;
        int pre = beg;
        int dis = Integer.MAX_VALUE;

        int count = t.length();
        int[] hash = new int[256];
        for(int i=0;i<t.length();i++){
            hash[(t.charAt(i))]++;
        }
        while(end<s.length()){
            int temp = (int)s.charAt(end++);
            if(hash[temp]-- > 0) count--;
            while(count==0){
                if(end-beg<dis) {
                    pre = beg;
                    dis = end-beg;
                }
                if(hash[(int)s.charAt(beg++)]++==0) count++;
            }
        }
        return dis==Integer.MAX_VALUE?"":s.substring(pre,pre+dis);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow2("a", "a"));
    }
}
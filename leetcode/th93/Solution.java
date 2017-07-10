package th93;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();

        help(s, new String[4], 0, res);

        return res;
    }

    private void help(String s, String[] ip, int index, List<String> res) {

        if ("".equals(s) && index == ip.length) {
            String re = "";
            for (int i = 0; i < ip.length; i++) {
                if (i != ip.length - 1) {
                    re += ip[i] + ".";
                } else {
                    re += ip[i];
                }
            }
            res.add(re);
        }
        if (index > 3) {
            return;
        }
        for (int i = 1; i < 4; i++) {
            if (s.length() < i) {
                return;
            }
            String sub = s.substring(0, i);
            if (isLegal(sub)) {
                ip[index] = sub;
                help(s.substring(i), ip, index + 1, res);
            }

        }

    }


    private boolean isLegal(String s) {
        if (Integer.parseInt(s) > 255) {
            return false;
        }
        if (s.length() > 1 && s.charAt(0) == '0') {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().restoreIpAddresses("0000"));


    }
}
package th166;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        double res = numerator * 1.0 / denominator;
        String[] ss = String.valueOf(res).split("\\.");
        if (ss[1].equals("0")) {
            return ss[0];
        }
        String fraction = "";
        String pre = "";
        for (int i = 0; i < ss[1].length(); i++) {
            char c = ss[1].charAt(i);

            int sub = ss[1].indexOf(c, i+1);
            if (sub == -1) {
                pre += c;
                continue;
            }
            if (ss[1].contains(ss[1].substring(i, sub))) {
                fraction = "(" + ss[1].substring(i, sub) + ")";
                break;
            }

        }
        if (fraction.equals("")) {
            return ss[0] + "." + ss[1];
        }

        return ss[0] + "." + pre + fraction;


    }

    public static void main(String[] args) {
        System.out.println(new Solution().fractionToDecimal(1, 6));
    }
}
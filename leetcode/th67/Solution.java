package th67;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    private boolean flag = false;

    public String addBinary(String a, String b) {
        if (a.equals(""))
            return b;
        if (b.equals("")) {
            return a;
        }
        int carry = 0;
        int m = a.length() - 1, n = b.length() - 1;
        StringBuilder res = new StringBuilder();
        while (m >= 0 || n >= 0 || carry != 0) {
            int sum = carry;
            if (m >= 0) {
                sum += a.charAt(m) - '0';
                m--;
            }
            if (n >= 0) {
                sum += b.charAt(n) - '0';
                n--;
            }
            res.append((char) (sum % 2 + '0'));
            carry = sum / 2;
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("101", "10"));
    }

}
package th401;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {

    public List<String> readBinaryWatch(int num) {
        List<String> res = new ArrayList<>();
        if (num == 0)
            return res;
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h * 64 + m) == num)
                    res.add(String.format("%d:%02d", h, m));

            }
        }
        return res;

    }

    public static void main(String[] args) {
        System.out.println(new Solution().readBinaryWatch(1));
    }
}
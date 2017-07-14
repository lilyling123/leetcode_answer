package th118;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            res.add(new ArrayList<>(row));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().generate(4));
    }
}
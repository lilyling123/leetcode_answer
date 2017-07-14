package th624;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;

        int max = arrays.get(0).get(arrays.get(0).size() - 1);

        int min = arrays.get(0).get(0);

        //非常巧妙
        for (int i = 1; i < arrays.size(); i++) {

            result = Math.max(result, Math.abs(arrays.get(i).get(0) - max));

            result = Math.max(result, Math.abs(arrays.get(i).get(arrays.get(i).size() - 1) - min));

            max = Math.max(max, arrays.get(i).get(arrays.get(i).size() - 1));

            min = Math.min(min, arrays.get(i).get(0));

        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(4);
        List<Integer> list2 = new ArrayList<>();
        list2.add(0);
        list2.add(5);

        List<List<Integer>> list4 = new ArrayList<>();
        list4.add(list1);
        list4.add(list2);
        list4.add(list2);
        System.out.println(new Solution().maxDistance(list4));
    }
}
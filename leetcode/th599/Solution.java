package th599;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();


        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int index = Integer.MAX_VALUE;

        for (int i = 0; i < list2.length; i++) {
            if (map.containsKey(list2[i])) {
                int m = map.get(list2[i]);
                if (index > m + i) {
                    res.clear();
                    index = m + i;
                    res.add(list2[i]);
                } else if (index == m + i) {

                    res.add(list2[i]);
                }

            }
        }

        String[] result = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        String[] restaurant = new Solution().findRestaurant(new String[]{
                "Shogun", "KFC", "Tapioca Express", "Burger King"
        }, new String[]{
                "KFC", "Shogun", "Burger King"
        });
        for (String s : restaurant) {
            System.out.println(s);
        }
    }
}
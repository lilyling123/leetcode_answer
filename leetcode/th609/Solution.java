package th609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {

        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < paths.length; i++) {
            String[] strs = paths[i].split(" ");
            String root = strs[0];
            for (int j = 1; j < strs.length; j++) {
                String str = strs[j];

                int left = str.indexOf("(");

                String content = str.substring(left, str.length() - 1);

                if (map.containsKey(content)) {
                    map.get(content).add(root + str.substring(0, left));
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(root + "/" + str.substring(0, left));
                    map.put(content, list);
                }
            }
        }

        List<List<String>> res = new ArrayList<>();
        for (List<String> list : map.values()) {
            if (list.size() > 1)
                res.add(list);
        }
        return res;
    }

    public static void main(String[] args) {

        System.out.println(new Solution().findDuplicate(new String[]{
                "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"
        }));
    }
}
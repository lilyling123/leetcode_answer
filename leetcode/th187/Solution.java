package th187;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> dna = new HashSet<>(), repeat = new HashSet<>();

        for (int i = 0; i + 9 < s.length(); i++) {
            String str = s.substring(i, i + 10);
            if (!dna.add(str)) {
                repeat.add(str);
            }
        }

        return new ArrayList<>(repeat);


    }
}
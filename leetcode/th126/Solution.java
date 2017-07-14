package th126;

import java.util.*;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    private static class Pair {
        LinkedList<String> target;
        Integer step;

        public Pair(LinkedList<String> target, Integer step) {
            this.target = target;
            this.step = step;
        }
    }

    public List<List<String>> findLadders(String red, String tax, List<String> list) {

        List<List<String>> res = new ArrayList<>();

        if (!list.contains(tax))
            return res;
        int minLen = Integer.MAX_VALUE;

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(new LinkedList<String>(), 1));
        queue.peek().target.add(red);

        List<String> remove = new ArrayList<>();

        while (!queue.isEmpty()) {

            Pair p = queue.poll();

            String curWord = p.target.getLast();

            int step = p.step;
            int flag = p.target.size();

            if (curWord.equals(tax)) {
                res.add(p.target);
            }

            if (p.target.size() > minLen)
                break;

            Iterator<String> it = list.iterator();

            while (it.hasNext()) {
                String nodeWord = it.next();
                int num = letterDiff(nodeWord, curWord);

                if (num == 1 &&
                        !p.target.contains(nodeWord)) {

                    LinkedList<String> temp = new LinkedList<>();

                    temp.addAll(p.target);

                    temp.add(nodeWord);
                    remove.add(nodeWord);

                    queue.add(new Pair(temp, step + 1));
                    if (nodeWord.equals(tax)) {
                        minLen = Math.min(step + 1, minLen);
                    }
                }
            }
            if (!queue.isEmpty() && flag < queue.peek().target.size()) {
                list.removeAll(remove);
                remove.clear();
            }

        }


        return res;
    }


    private int letterDiff(String s1, String s2) {
        char[] w1 = s1.toCharArray();
        char[] w2 = s2.toCharArray();
        int count = 0;
        for (int i = 0; i < w1.length; i++) {
            if (w1[i] != w2[i]) {
                count++;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        System.out.println(new Solution().findLadders("a", "c", list));

//        list.add("hot");
//        list.add("cog");
//        list.add("dog");
//        list.add("tot");
//        list.add("hog");
//        list.add("hop");
//        list.add("pot");
//        list.add("dot");
//        System.out.println(new Solution().findLadders("hot", "dog", list));

//        String[] strings = new String[]{"ted", "tex", "red", "tax", "tad", "den", "rex", "pee"};
//
//        list.addAll(Arrays.asList(strings));
//        set.addAll(Arrays.asList(strings));
//        System.out.println(new Solution().findLadders("red", "tax", list));

//        System.out.println(new Solution().findLadders("red", "tax", set));
        String[] ss = new String[]{"si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye"};

        list.addAll(Arrays.asList(ss));
        System.out.println(new Solution().findLadders("qa", "sq", list));
        Arrays.sort(ss);
        System.out.println(Arrays.toString(ss));


    }

}
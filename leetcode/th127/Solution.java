package th127;

import java.util.*;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    private static class Pair {
        char[] target;
        Integer step;

        public Pair(char[] target, Integer step) {
            this.target = target;
            this.step = step;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        char[] begin = beginWord.toCharArray();

        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(begin, 1));

        while (!queue.isEmpty()) {
            char[] target = queue.peek().target;
            int step = queue.peek().step;
            queue.poll();

            Iterator<String> it = wordList.iterator();
            while (it.hasNext()) {
                String words = it.next();
                char[] word = words.toCharArray();

                int count = letterDiff(target, word);


                if (count == 1) {
                    queue.offer(new Pair(word, step + 1));
                    it.remove();
                    if (endWord.equals(words)) {
                        return step + 1;
                    }
                }
            }
        }
        return 0;
    }

    private int letterDiff(char[] w1, char[] w2) {
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
        list.add("a");
        list.add("b");
        list.add("c");
        System.out.println(new Solution().ladderLength("a", "c", list));
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

//        System.out.println(new Solution().ladderLength("hit", "cog", list));
    }
}
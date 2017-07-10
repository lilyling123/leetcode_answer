package th51;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {
    boolean[] col, dia1, dia2;
    List<List<String>> res;

    public List<List<String>> solveNQueens(int n) {
        col = new boolean[n];
        dia1 = new boolean[2 * n - 1];
        dia2 = new boolean[2 * n - 1];
        List<Integer> row = new LinkedList<>();

        res = new ArrayList<>();
        putQueen(n, 0, row);

        return res;

    }

    private void putQueen(int n, int index, List<Integer> row) {
        if (index == n) {
            res.add(generateBoard(n, row));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!col[i] && !dia1[index + i] && !dia2[index - i + n - 1]) {
                row.add(i);
                col[i] = true;
                dia1[index + i] = true;
                dia2[index - i + n - 1] = true;
                putQueen(n, index + 1, row);
                col[i] = false;
                dia1[index + i] = false;
                dia2[index - i + n - 1] = false;
                row.remove(row.size() - 1);
            }
        }

    }

    private List<String> generateBoard(int n, List<Integer> row) {
        List<String> board = new ArrayList<>();
        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < n - 1; i++) {
            sb.append(".");
        }
        for (int i = 0; i < n; i++) {
            int q = row.get(i);
            sb.insert(q, "Q");
            board.add(sb.toString());
            sb.deleteCharAt(q);

        }

        return board;
    }

    public static void main(String[] args) {

        List<List<String>> lists = new Solution().solveNQueens(4);

        for (int i = 0; i < lists.size(); i++) {
            for (String s : lists.get(i)) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
}
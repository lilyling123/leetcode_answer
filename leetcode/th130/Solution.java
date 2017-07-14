package th130;

/**
 * Created by lily_ling on 2017/6/15.
 */
public class Solution {

    //状态的转换
    public void solve(char[][] board) {
        if (board.length == 0)
            return;

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            dfs(board, i, 0, row, col);
            if (col > 1)
                dfs(board, i, col - 1, row, col);
        }

        for (int j = 1; j + 1 < col; j++) {
            dfs(board, 0, j, row, col);
            if (row > 1)
                dfs(board, row - 1, j, row, col);
        }
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (board[i][j] == 'O')
                    board[i][j] = 'X';

        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                if (board[i][j] == '1')
                    board[i][j] = 'O';

    }


    private void dfs(char[][] board, int i, int j, int row, int col) {
        if (board[i][j] == 'O') {
            board[i][j] = '1';
            if (i > 1)
                dfs(board, i - 1, j, row, col);
            if (j > 1)
                dfs(board, i, j - 1, row, col);
            if (i + 1 < row)
                dfs(board, i + 1, j, row, col);
            if (j + 1 < col)
                dfs(board, i, j + 1, row, col);

        }
    }

    public static void main(String[] args) {
        char[][] board1 = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        char[][] board2 = new char[][]{
                {'O', 'O', 'O'},
                {'O', 'O', 'O'},
                {'O', 'O', 'O'}
        };
        new Solution().solve(board1);

        for (int i = 0; i < board1.length; i++) {
            for (int j = 0; j < board1[i].length; j++) {
                System.out.print(board1[i][j]);
            }
            System.out.println();
        }
    }
}
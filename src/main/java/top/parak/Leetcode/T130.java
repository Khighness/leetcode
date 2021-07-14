package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-15
 * @apiNote 130. 被围绕的区域
 */

/**
 * Problem:
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 */
public class T130 {

    /**
     * DFS
     * 先处理与边界连通的O，标记为K，那么剩下的O直接替换成X即可，最后把K换回O
     */
    public void solve(char[][] board) {
        int height = board.length, width = board[0].length;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i == 0 || i == height - 1 || j == 0 || j == width - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'K') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;
        if (board[i][j] != 'O')
            return;
        board[i][j] = 'K';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);
    }
}

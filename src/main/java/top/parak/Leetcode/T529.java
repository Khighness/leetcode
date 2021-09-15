package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-21
 * @apiNote 529. 扫雷游戏
 */
public class T529 {

    private int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        dfs(board, click[0], click[1]);
        return board;
    }

    private void dfs(char[][] board, int x, int y) {
        // 越界
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
            return;
        // 已挖出
        if (board[x][y] == 'B' || board[x][y] == 'X' || (board[x][y] >= '1' && board[x][y] <= '8'))
            return;
        // 地雷
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
            return;
        }
        // 空
        int count = get(board, x, y);
        if (count == 0) {
            board[x][y] = 'B';
            for (int i = 0; i < 8; i++) {
                dfs(board, x + dir[i][0], y + dir[i][1]);
            }
        } else {
            board[x][y] = (char) ('0' + count);
        }
    }

    private int get(char[][] board, int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int newX = x + dir[i][0], newY = y + dir[i][1];
            if (newX >= 0 && newY >= 0
            &&  newX < board.length && newY < board[0].length
            &&  board[newX][newY] == 'M') count++;
        }
        return count;
    }

}

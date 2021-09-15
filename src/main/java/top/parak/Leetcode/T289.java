package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-22
 * @apiNote 289. 生命游戏
 */
public class T289 {
    private final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};

    /**
     * 状态 0： 00，死的，下一轮还是死的
     * 状态 1： 01，活的，下一轮死了
     * 状态 2： 10，死的，下一轮复活
     * 状态 3： 11，活的，下一轮继续活着
     */
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = getNeighCount(board, i, j);
                // 旁边活细胞数量为2或者3，存活
                if (board[i][j] == 1 && (count == 2 || count == 3)  ) {
                    board[i][j] = 3;
                }
                // 死亡细胞旁边3个活细胞，复活
                if (board[i][j] == 0 && count == 3) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private int getNeighCount(int[][] board, int x, int y) {
        int m = board.length, n = board[0].length;
        int count = 0, nx, ny;
        for (int[] dir : dirs) {
            nx = x + dir[0];
            ny = y + dir[1];
            if (check(m, n, nx, ny)) {
                count += board[nx][ny] & 1;
            }
        }
        return count;
    }

    private boolean check(int m, int n, int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

}

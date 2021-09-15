package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-28
 * @apiNote 79. 单词搜索
 */
public class T79 {
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int row, col, len;
    private char[][] board;
    private char[] arr;
    private boolean[][] visit;

    /**
     * DFS入口：遍历board，找到与word第一个字符相同的元素(i, j)
     * DFS过程：从(i, j)出发，上下左右试探，匹配下一个字母
     */
    public boolean exist(char[][] board, String word) {
        this.row = board.length;
        this.col = board[0].length;
        this.len = word.length();
        this.board = board;
        this.arr = word.toCharArray();
        this.visit = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int index) {
        if (index == len - 1) {
            return board[x][y] == arr[index];
        }
        if (board[x][y] == arr[index]) {
            visit[x][y] = true;
            for (int[] dir : dirs) {
                int newX = x + dir[0];
                int newY = y + dir[1];
                if (newX >= 0 && newY >= 0 && newX < row && newY < col && !visit[newX][newY]) {
                    // 下一个
                    if (dfs(newX,  newY, index + 1)) {
                        return true;
                    }
                }
            }
            // 回溯
            visit[x][y] = false;
        }
        return false;
    }
}

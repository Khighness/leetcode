package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-21
 * @apiNote 529. 扫雷游戏
 */

/**
 * Problem:
 * 让我们一起来玩扫雷游戏！
 * 给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
 * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
 * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
 * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
 * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
 * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
 */
public class T529 {
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

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

    public static void main(String[] args) {
        char[][] chars = new T529().updateBoard(
                new char[][]{
                        {'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'M', 'E', 'E'},
                        {'E', 'E', 'E', 'E', 'E'},
                        {'E', 'E', 'E', 'E', 'E'},
                }, new int[]{3, 0}
        );
    }
}

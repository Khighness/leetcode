package top.parak.Practice.WY;

/**
 * @author KHighness
 * @since 2021-08-21
 */
public class T4 {
    private static int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int min = Integer.MAX_VALUE;

    private static void process(int[][] input) {
        dfs(input, 0, 0, 0);
    }

    private static void dfs(int[][] input, int x, int y, int cur) {
        // 越界
        if (!check(input.length, input[0].length, x, y))
            return;
        // 障碍物或者已经走过
        if (input[x][y] == 2 || input[x][y] == -1)
            return;
        // 非起始位置
        if (!(x == 0 && y == 0)) {
            cur += input[x][y] == 1 ? 1 : 2;
        }
        // 到达终点
        if (x == input.length - 1 && y == input[0].length - 1) {
            min = Math.min(cur, min);
            return;
        }
        // 经过地方标记
        input[x][y] = -1;
        for (int[] dir : dirs) {
            dfs(input, x + dir[0], y + dir[1], cur);
        }
    }

    private static boolean check(int m, int n, int x, int y) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    public int minSailCost (int[][] input) {
        dfs(input, 0, 0, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}

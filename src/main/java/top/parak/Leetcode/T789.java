package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-08-22
 * @apiNote 789. 逃脱阻碍者
 */
public class T789 {

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int[] source = {0, 0};
        // 玩家与目的地的曼哈顿距离
        int dis = manhattanDistance(source, target);
        // 只要所有追捕者与目的地的曼哈顿距离大于dis，就可以成功
        for (int[] ghost : ghosts) {
            if (manhattanDistance(ghost, target) <= dis) {
                return false;
            }
        }
        return true;
    }

    // 曼哈顿距离
    private int manhattanDistance(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }

}

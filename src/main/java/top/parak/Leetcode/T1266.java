package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020-09-25
 * @apiNote 1266. 访问所有点的最小时间
 */
public class T1266 {

    public int minTimeToVisitAllPoints(int[][] points) {
        int min = 0;
        for (int i = 1; i < points.length; i++) {
            // 两点之间需要走的最短次数是 MAX(|X1-X2|,|Y1-Y2|)
            min += Math.max(Math.abs(points[i-1][0] - points[i][0]), Math.abs(points[i-1][1] - points[i][1]));
        }
        return min;
    }

}

package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/25 20:36
 * @apiNote 1266. 访问所有点的最小时间
 */

/**
 * Problem:
 * 平面上有 n 个点，点的位置用整数坐标表示 points[i] = [xi, yi]。请你计算访问所有这些点需要的最小时间（以秒为单位）。
 *
 * 你可以按照下面的规则在平面上移动：
 *
 * 每一秒沿水平或者竖直方向移动一个单位长度，或者跨过对角线（可以看作在一秒内向水平和竖直方向各移动一个单位长度）。
 * 必须按照数组中出现的顺序来访问这些点。
 *
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

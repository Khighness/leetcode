package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2020/11/23
 * @apiNote 874. 模拟行走机器人
 */

import java.util.*;

/**
 * Problem:
 * 机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令：
 * -2：向左转 90 度
 * -1：向右转 90 度
 * 1 <= x <= 9：向前移动 x 个单位长度
 * 在网格上有一些格子被视为障碍物。
 * 第 i 个障碍物位于网格点  (obstacles[i][0], obstacles[i][1])
 * 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。
 * 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。
 */
public class T874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        /* 将所有的障碍物坐标以字符串的形式存储在set集合中 */
        Set<String> obs = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obs.add(obstacle[0] + "," + obstacle[1]);
        }
        /**
         * dir      现在方向度数(0-东方, 1-北方，2-西方，3-南方)
         * currX    现在的X坐标
         * currY    现在的Y坐标
         * masDist  最大的欧氏距离
         */
        int dir = 1, currX = 0, currY = 0, maxDist = 0;
        int[][] next = { {1, 0}, {0, 1}, {-1, 0}, {0, -1} };
        for (int i = 0; i < commands.length; i++) {
            /* 下一步的X和Y坐标 */
            int nextX = 0, nextY = 0;
            if (commands[i] < 0) {
                if (commands[i] == -2) {
                    dir = (dir + 1) % 4;
                } else {
                    if (dir > 0) {
                        dir = (dir - 1) % 4;
                    } else {
                        /* 防止dir变为负数 */
                        dir = 3;
                    }
                }
            } else {
                for (int k = 0; k < commands[i]; k++) {
                    nextX = currX + next[dir][0];
                    nextY = currY + next[dir][1];
                    /* 遇到障碍物结束移动 */
                    if (obs.contains(nextX+","+nextY)) {
                        break;
                    }
                    /* 无障碍物更新坐标与结果 */
                    currX = nextX;
                    currY = nextY;
                    maxDist = Math.max(maxDist, currX * currX + currY * currY);
                }
            }
        }
        return maxDist;
    }

}

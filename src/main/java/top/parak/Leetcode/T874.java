package top.parak.Leetcode;

import java.util.*;


/**
 * @author KHighness
 * @since 2020-11-23
 * @apiNote 874. 模拟行走机器人
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

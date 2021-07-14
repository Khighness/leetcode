package top.parak.Leetcode;

/**
 * @author KHighness
 * @date 2020/9/29 21:22
 * @apiNote 1552. 两球之间的磁力
 */

/**
 * Problem:
 * 在代号为 C-137 的地球上，Rick 发现如果他将两个球放在他新发明的篮子里，它们之间会形成特殊形式的磁力。
 * Rick 有 n 个空的篮子，第 i 个篮子的位置在 position[i] ，Morty 想把 m 个球放到这些篮子里，使得任意两球间 最小磁力 最大。
 * 已知两个球如果分别位于 x 和 y ，那么它们之间的磁力为 |x - y| 。
 * 给你一个整数数组 position 和一个整数 m ，请你返回最大化的最小磁力。
 */

import java.util.Arrays;

/**
 * Solution:
 * 1、两球的最小距离 MinDistance = 1
 *    两球的最小距离的最大值 MaxDistance = (最后位置的球坐标 - 最前位置的球坐标) / (球数 - 1)
 * 2、有最小和最大，直觉二分法
 *    以二分的中间值，作为间距去摆放球。如果摆放的球数 >= m，可认为需要增加球距；
 *    否则需要减少球距离
 */
public class T1552 {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int min = 1;
        int max = (position[position.length -1] - position[0]) / (m -1);
        int ans = 1;
        while (min <= max) {
            int mid = min + (max - min) / 2;
            if (check(position, mid, m)) {
                ans = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return ans;
    }

    public boolean check(int[] position, int distance, int m) {
        int count = 1, i = 0;
        for (int k = 1; k < position.length; k++) {
            if (position[k]-position[i] >= distance) {
                count++;
                i = k;
                if (count >= m) return true;
            }
        }
        return false;
    }
}

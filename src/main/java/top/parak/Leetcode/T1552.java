package top.parak.Leetcode;

import java.util.Arrays;

/**
 * @author KHighness
 * @since 2020-09-29
 * @apiNote 1552. 两球之间的磁力
 */
public class T1552 {

    /**
     * Solution:
     * 1、两球的最小距离 MinDistance = 1
     *    两球的最小距离的最大值 MaxDistance = (最后位置的球坐标 - 最前位置的球坐标) / (球数 - 1)
     * 2、有最小和最大，直觉二分法
     *    以二分的中间值，作为间距去摆放球。如果摆放的球数 >= m，可认为需要增加球距；
     *    否则需要减少球距离
     */
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

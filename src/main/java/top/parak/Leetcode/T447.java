package top.parak.Leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author KHighness
 * @since 2021-09-13
 */
public class T447 {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] point : points) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] ints : points) {
                int dx = point[0] - ints[0];
                int dy = point[1] - ints[1];
                int dis = dx * dx + dy * dy;
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for (int val : map.values()) {
                ans += val * (val - 1);
            }
        }
        return ans;
    }
}

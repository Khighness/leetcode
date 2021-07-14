package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-03-29
 * @apiNote 787. K 站中转内最便宜的航班
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Problem:
 * 有 n 个城市通过 m 个航班连接。每个航班都从城市 u 开始，以价格 w 抵达 v。
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，你的任务是找到从 src 到 dst 最多经过 k 站中转的最便宜的价格。 如果没有这样的路线，则输出 -1。
 */
public class T787 {

    /**
     * Dijkstra
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[][] matrix = new int[n][n];
        for (int[] flight : flights) {
            matrix[flight[0]][flight[1]] = flight[2];
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[] {src, 0, K + 1});
        while (!minHeap.isEmpty()) {
            int[] front = minHeap.poll();
            int v = front[0];
            int price = front[1];
            int k = front[2];

            if (v == dst) {
                return price;
            }
            if (k > 0) {
                for (int i = 0; i < n; i++) {
                    if (matrix[v][i] > 0) {
                        minHeap.offer(new int[]{i, price + matrix[v][i], k - 1});
                    }
                }
            }
        }
        return -1;
    }
}

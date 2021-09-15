package top.parak.Leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author KHighness
 * @since 2021-03-29
 * @apiNote 787. K 站中转内最便宜的航班
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

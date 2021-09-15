package top.parak.Leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author KHighness
 * @since 2021-08-07
 * @apiNote 847. 访问所有节点的最短路径
 */
public class T847 {

    public int shortestPathLength(int[][] graph) {
        int n = graph.length;
        int mask = 1 << n;

        // 初始化
        int[][] dist = new int[mask][n];
        for (int i = 0; i < mask; i++)
            Arrays.fill(dist[i], Integer.MAX_VALUE);

        // 将起始的起点状态入队，并设起点距离为0
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            dist[1 << i][i] = 0;
            deque.addLast(new int[]{1 << i, i});
        }

        // BFS，如果从点u能够到达点i，则更新距离并进行入队
        while (!deque.isEmpty()) {
            int[] poll = deque.pollFirst();
            int state = poll[0], u = poll[1], step = dist[state][u];
            if (state == mask - 1) return step;
            for (int i : graph[u]) {
                if (dist[state | (1 << i)][i] == Integer.MAX_VALUE) {
                    dist[state | 1 << i][i] = step + 1;
                    deque.addLast(new int[]{state | (1 << i), i});
                }
            }
        }

        return -1;
    }

}

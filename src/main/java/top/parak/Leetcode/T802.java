package top.parak.Leetcode;

import java.util.*;

/**
 * @author KHighness
 * @since 2021-08-07
 * @apiNote 802. 找到最终的安全状态
 */
public class T802 {

    /**
     * 反向拓扑排序，入度改为出度
     */
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        // 出度
        int[] outDegrees = new int[n];
        // 有向边
        Map<Integer, List<Integer>> edges = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                List<Integer> cur = edges.getOrDefault(j, new ArrayList<>());
                cur.add(i);
                edges.put(j, cur);
                outDegrees[i]++;
            }
        }
        // 出度0集合
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (outDegrees[i] == 0) {
                queue.add(i);
            }
        }
        // 拓扑排序
        List<Integer> ans = new ArrayList<>();
        while (queue.size() > 0) {
            int u = queue.poll();
            ans.add(u);
            if (edges.containsKey(u)) {
                for (int v : edges.get(u)) {
                    outDegrees[v]--;
                    if (outDegrees[v] == 0) {
                        queue.add(v);
                    }
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }

}

package top.parak.Leetcode;

import java.util.*;

/**
 * @author KHighness
 * @since 2021-05-15
 * @apiNote 210. 课程表 II
 */
public class T210 {

    /**
     * 拓扑排序
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegrees = new int[numCourses];
        List<List<Integer>> edges = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] res = new int[numCourses]; int index = 0;
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            inDegrees[pre[0]] += 1;
            edges.get(pre[1]).add(pre[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            res[index++] = u;
            for (Integer v : edges.get(u)) {
                if (--inDegrees[v] == 0) {
                    queue.add(v);
                }
            }
            numCourses--;
        }
        return numCourses == 0 ? res : new int[0];
    }

}

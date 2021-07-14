package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-15
 * @apiNote 210. 课程表 II
 */

import java.util.*;

/**
 * Problem:
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
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

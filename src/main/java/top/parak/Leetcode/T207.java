package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-15
 * @apiNote 207. 课程表
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem:
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 */
public class T207 {
    /**
     * 入度表（拓扑排序）
     * 每出队一次，课程数-1，课程数为0 => true
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度表
        int[] inDegrees = new int[numCourses];
        // 有向边
        List<List<Integer>> edges = new ArrayList<>();
        // 入度0集合
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        // 有向边 pre[1] -> pre[0]
        for (int[] pre : prerequisites) {
            inDegrees[pre[0]] += 1;
            edges.get(pre[1]).add(pre[0]);
        }
        // 将入度为0的添加到队列
        for (int i = 0; i < numCourses; i++) {
            if (inDegrees[i] == 0)
                queue.add(i);
        }
        while (!queue.isEmpty()) {
            Integer u = queue.poll();
            numCourses--;
            for (Integer v : edges.get(u)) {
                if (--inDegrees[v] == 0)
                    queue.add(v);
            }
        }
        return numCourses == 0;
    }
}

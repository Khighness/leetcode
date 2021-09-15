package top.parak.Leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * @author KHighness
 * @since 2021-05-15
 * @apiNote 207. 课程表
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

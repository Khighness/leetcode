package top.parak.Leetcode;

import java.util.PriorityQueue;

/**
 * @author KHighness
 * @since 2021-08-15
 * @apiNote 1337. 矩阵中战斗力最弱的 K 行
 */
public class T1337 {

    /**
     * 二分查找 + 大根堆
     */
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
           if (a[0] != b[0]) return b[0] - a[0];
           return b[1] - a[1];
        });
        for (int i = 0; i < m; i++) {
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (mat[i][mid] >= 1) l = mid;
                else r = mid - 1;
            }
            int cur = mat[i][r] >= 1 ? r + 1 : r;
            if (queue.size() == k && queue.peek()[0] > cur)
                queue.poll();
            if (queue.size() < k)
                queue.add(new int[] {cur, i});
        }
        int[] ans = new int[k];
        int index = k - 1;
        while (!queue.isEmpty()) {
            ans[index--] = queue.poll()[1];
        }
        return ans;
    }

}

package top.parak.Leetcode;

/**
 * @author KHighness
 * @since 2021-05-12
 * @apiNote 120. 三角形最小路径和
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
public class T120 {

    /**
     * 动态规划
     * dp[i][j]表示(i, j)到达三角形的底的最小路径
     * 注意：从三角形底下向上遍历，从下向上走，(i, j)的来源点只能有(i + 1, j)和(i + 1, j + 1)
     * 状态转移方程：dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] dp = new int[height][height];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = height - 1; i >= 0; i--) {
            List<Integer> curr = triangle.get(i);
            int width = curr.size();
            for (int j = 0; j < width; j++) {
                if (i == height - 1) { // 初始化
                    dp[i][j] = curr.get(j);
                } else { // 状态转移
                    dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + curr.get(j);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        T120 t120 = new T120();
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>(); list1.add(2);
        List<Integer> list2 = new ArrayList<>(); list2.add(3); list2.add(4);
        List<Integer> list3 = new ArrayList<>(); list3.add(6); list3.add(5); list3.add(7);
        List<Integer> list4 = new ArrayList<>(); list4.add(4); list4.add(1); list4.add(8); list4.add(3);
        list.add(list1); list.add(list2); list.add(list3); list.add(list4);
        System.out.println(t120.minimumTotal(list));
    }


}

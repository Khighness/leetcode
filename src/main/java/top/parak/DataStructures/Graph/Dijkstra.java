package top.parak.DataStructures.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author KHighness
 * @since 2021-05-20
 * @apiNote 单源最短路径Dijkstra算法
 */

public class Dijkstra {
    /**
     * 防止两个MAX_VALUE相加栈溢出
     */
    public final static int MAX_VALUE = Integer.MAX_VALUE >> 1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //顶点数
        int vertex = input.nextInt();
        //边数
        int edge = input.nextInt();
        int[][] matrix = new int[vertex][vertex];
        //初始化邻接矩阵
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                matrix[i][j] = MAX_VALUE;
            }
        }
        for (int i = 0; i < edge; i++) {
            int source = input.nextInt();
            int target = input.nextInt();
            int weight = input.nextInt();
            matrix[source][target] = weight;
        }
        // 源点
        int source = input.nextInt();
        process(matrix, source);
    }

    public static int[] process(int[][] matrix, int source) {
        int len = matrix.length;
        // 最短路径长度
        int[] shortest = new int[len];
        // 判断是否求出
        boolean[] visited = new boolean[len];
        // 存储输出路径
        List<String> path = new ArrayList<>(len);
        // 初始化
        for (int i = 0; i < matrix.length; i++) {
            path.add(source + " => " + i);
        }
        shortest[source] = 0;
        visited[source] = true;

        for (int i = 1; i < len; i++) {
            int min = Integer.MAX_VALUE;
            int index = source;
            // 寻找到source最近的顶点index
            for (int k = 0; k < len; k++) {
                if (!visited[k] && matrix[source][k] < min) {
                    min = matrix[source][k];
                    index = k;
                }
            }
            shortest[index] = min;
            visited[index] = true;
            // 以index为中间点，修改从source到未访问各点的距离
            for (int k = 0; k < matrix.length; k++) {
                if (!visited[k] && matrix[source][index] + matrix[index][k] < matrix[source][k]) {
                    matrix[source][k] = matrix[source][index] + matrix[index][k];
                    path.set(k, path.get(index) + " => " + k);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            if (shortest[i] == MAX_VALUE)
                System.out.printf("source到%d不可达\n", i);
            else
                System.out.printf("source到%d的最短路径：%s, 路径长度：%d\n", i, path.get(i), shortest[i]);
        }
        return shortest;
    }

}

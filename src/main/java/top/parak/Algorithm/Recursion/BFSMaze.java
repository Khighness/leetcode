package top.parak.Algorithm.Recursion;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author KHighness
 * @since 2021-05-14
 * @apiNote BFS迷宫问题
 */
public class BFSMaze {
    static class Node {
        int x;
        int y;
        int dis;
        Node prev;
        public Node(int x, int y, int dis, Node prev) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.prev = prev;
        }
    }

    /**
     * 广度优先搜索
     * 1. 将起点入队
     * 2. 队首结点可扩展点入队【右下左上】
     *    如果没有可扩展点，将队首结点出队
     * 3. 重复这个步骤，知道到达目标位置或队列为空
     */
    public static void bfs(int[][] map) {
        int height = map.length, width = map[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Deque<Node> queue = new LinkedList<>();
        // 起点入队
        Node start = new Node(0,0,0, null);
        queue.offer(start);
        // 已走为2
        map[0][0] = 2;
        // 循环遍历
        Node temp = null, next = null;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = temp.x + dirs[i][0];
                int newY = temp.y + dirs[i][1];
                // 检查越界
                if (newX < 0 || newX >= height || newY < 0 || newY >= width) {
                    continue;
                }
                // 障碍和已标记
                if (map[newX][newY] == 1 || map[newX][newY] == 2) {
                    continue;
                }
                // 构造节点
                next = new Node(newX, newY, temp.dis + 1, temp);
                // 到达目标
                if (newX == height - 1 && newY == width - 1) {
                    break;
                }
                // 标记已走
                map[newX][newY] = 2;
                queue.add(next);
            }
        }
        System.out.printf("最短长度: %d\n", next.dis);
        queue.clear();
        queue.offer(next);
        queue.addFirst(next);
        Node pre = next.prev;
        while (pre != null) {
            queue.addFirst(pre);
            pre = pre.prev;
        }
        System.out.print("最短路径：");
        while (queue.size() != 1) {
            Node node = queue.pop();
            System.out.printf("(%d, %d) => ", node.x, node.y);
        }
        Node node = queue.pop();
        System.out.printf("(%d, %d)\n", node.x, node.y);
    }

    public static void print(int[][] map) {
        for (int[] row : map) {
            for (int i  : row) {
                if (i == 1) {
                    System.out.print("■\t");
                } else if (i == 2) {
                    System.out.print("●\t");
                } else {
                    System.out.printf("%d\t", i);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] map = {
                {0, 1, 1, 0, 1, 0, 1, 1},
                {0, 1, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {1, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 0}
        };
        System.out.println(">>> 地图 <<<");
        print(map);
        bfs(map);
        System.out.println(">>> 路径 <<<");
        print(map);
    }
}

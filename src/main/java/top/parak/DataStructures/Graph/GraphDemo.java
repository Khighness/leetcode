package top.parak.DataStructures.Graph;

import java.util.*;

/**
 * @author KHighness
 * @since 2020-09-27
 * @apiNote 图的创建
 */
public class GraphDemo {

    private ArrayList<String> vertexList; // 存储顶点集合

    private int[][] edges;                // 存储图对应的邻接矩阵

    private int numOfEdges;               // 表示边的数目

    public boolean[] isVisited;           // 记录结点是否被访问

    /**
     * 构造器
     * @param n 结点数量
     */
    public GraphDemo(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<String>();
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    /**
     * 插入结点
     * @param vertex 结点的值
     */
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * 插入边
     * @param v1 表示点的下标
     * @param v2 表示点的下标
     * @param weight 表示边的权值
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }

    /**
     * 结点个数
     * @return
     */
    public int getNumOfVertex() {
        return vertexList.size();
    }

    /**
     * 边的数量
     * @return
     */
    public int getNumOfEdges() {
        return numOfEdges;
    }

    /**
     * 返回结点i对应的数据
     * @param i
     * @return
     */
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    /**
     * 返回v1和v2的权值
     * @param v1
     * @param v2
     * @return
     */
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    /**
     * 得到第一个邻接节点的下标
     * @param index
     * @return 如果存在则返回下标，否咋返回-1
     */
    public int getFirstNeighbor(int index) {
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 根据前一个邻接结点的下标来获取下一个邻接结点
     * @param v1
     * @param v2
     * @return 如果存在则返回下标，否咋返回-1
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v2][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 显示图的邻接矩阵
     */
    public void showGraph() {
        for (int[] row : edges) {
            Arrays.stream(row).forEach(i -> { System.out.print(i + " "); });
            System.out.println();
        }
    }

    /**
     * 递归
     * DFS: 深度优先遍历
     * 过程:
     * 1、访问结点v
     * 2、从v的未被访问过的邻接结点中选取一个结点w，从w出发进行深度优先遍历
     * 3、重复上述两步
     */
    public void DFS1() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            isVisited[i] = false;
        }
        DFS(0);
    }

    public void DFS(int v) {
        isVisited[v] = true;
        System.out.print(getValueByIndex(v) + "->");
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (edges[v][i] == 1 && !isVisited[i]) {
                DFS(i);
            }
        }
    }


    /**
     * 使用栈 非递归
     * DFS: 深度优先遍历
     */
    public void DFS2() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            isVisited[i] = false;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                stack.add(i);
                while ( !stack.isEmpty() ) {
                    int curr = stack.pop();
                    // 如果该节点还没有被遍历，则遍历该结点并将子结点入栈
                    if (!isVisited[curr]) {
                        System.out.print(getValueByIndex(curr) + "->");
                        isVisited[curr] = true;
                        // 未遍历的子结点入栈
                        for (int j = getNumOfVertex() - 1; j > 0; j--) {
                            if (edges[curr][j] == 1 && !isVisited[j]) {
                                stack.add(j);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * BFS: 广度优先遍历
     * 过程：
     * 1、创建一个队列queue，用来存放每一层的结点
     * 2、从第一个结点V0开始访问，将isVisited[0]置为true，同时将V0入队
     * 3、队列不为空，重复操作：
     *    (1) 队列头结点u出队
     *    (2) 依次检查u的所有邻接结点w，若isVisited[w]的为false，则访问w，并将isVisited[w]置为true，同时将w入队
     */
    public void BFS() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            isVisited[i] = false;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(0);
        isVisited[0] = true;
        while ( !queue.isEmpty() ) {
            int curr = queue.removeFirst();
            System.out.print(getValueByIndex(curr) + "->");
            for (int i = 0; i < getNumOfVertex(); i++) {
                if (edges[curr][i] == 1 && isVisited[i] == false) {
                    isVisited[i] = true;
                    queue.addLast(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        // 结点
        String vertexValue[] = {"V1", "V2", "V3", "V4", "V5", "V6", "V7", "V8"};
        GraphDemo graph = new GraphDemo(vertexValue.length);
        // 添加结点
        Arrays.stream(vertexValue).forEach( s -> { graph.insertVertex(s); });
        // 添加边
        // V1-V2 V1-V3 V2-V4 V2-V5 V4-V8 V5-V8 V3-V6 V3-V7 V6-V7
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
        // 显示矩阵
        System.out.println("邻接矩阵");
        graph.showGraph();
        // 测试DFS
        System.out.println("\n深度优先");
        graph.DFS1();
        // 测试BFS
        System.out.println("\n广度优先");
        graph.BFS();
    }

}

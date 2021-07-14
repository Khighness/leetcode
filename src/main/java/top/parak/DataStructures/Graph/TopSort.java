package top.parak.DataStructures.Graph;

import java.util.*;

/**
 * @author KHighness
 * @since 2021-05-15
 * @apiNote 拓扑排序
 */

public class TopSort {

    /** 节点 */
    private static class Node {
        /** 值 */
        public Object val;
        /** 入度 */
        public int in;

        public Node(Object val) {
            this.val = val;
        }
    }

    /** 图 */
    private static class Graph {
        /** 节点 */
        public Set<Node> vertexSet = new HashSet<>();

        /** 有向边 */
        public Map<Node, Set<Node>> edgeMap = new HashMap<>();

        /**
         * 添加边
         * @param u 边的起点
         * @param v 边的终点
         * @return true 代表添加成功，false代表边已经存在
         */
        public boolean addEdge(Node u, Node v) {
            vertexSet.add(u);vertexSet.add(v);
            if (edgeMap.containsKey(u) && edgeMap.get(u).contains(v))
                return false;
            if (edgeMap.containsKey(u)) {
                edgeMap.get(u).add(v);
            }
            else {
                Set<Node> temp = new HashSet<>();
                temp.add(v);
                edgeMap.put(u, temp);
            }
            v.in++;
            return true;
        }
    }

    /** 图 */
    private Graph graph;

    /** 结果集 */
    private List<Node> res;

    /** 存储入度为0的顶点 */
    private Queue<Node> set;

    public TopSort(Graph graph) {
        init(graph);
        process();
    }

    /**
     * 初始化，将所有入度为0的节点加入到集合
     */
    public void init(Graph graph) {
        this.graph = graph;
        this.res = new ArrayList<>();
        this.set = new LinkedList<>();
        for (Node node : this.graph.vertexSet) {
            if (node.in == 0) {
                this.set.add(node);
            }
        }
    }

    /**
     * 处理，集合出队，添加到结果集，并将它从图中剔除，直到集合为空
     */
    private void process() {
        while (!set.isEmpty()) {
            Node u = set.poll();
            // 将当前顶点加入到结果集
            res.add(u);
            if (graph.edgeMap.keySet().isEmpty())
                return;
            // 遍历当前顶点的所有边
            for (Node v : graph.edgeMap.get(u)) {
                // 移除边，即减少入度
                v.in -= 1;
                // 入度为0，加入集合
                if (v.in == 0) set.add(v);
            }
            graph.vertexSet.remove(u);
            graph.edgeMap.remove(u);
        }
        // 还有其他点，说明有环
        if (!graph.vertexSet.isEmpty())
            throw new IllegalArgumentException("Graph has cycle");
    }

    /**
     * @return 结果集
     */
    public List<Node> getRes() {
        return res;
    }

    /**
     * 打印结果
     */
    public void printRes() {
        for (int i = 0; i < res.size(); i++) {
            if (i != res.size() - 1)
                System.out.printf("%s -> ", res.get(i).val);
            else
                System.out.printf("%s", res.get(i).val);
        }
    }

    public static void main(String[] args) {
        Node A = new Node("A");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        Node E = new Node("E");
        Node F = new Node("F");
        Graph graph = new Graph();
        graph.addEdge(A, B);
        graph.addEdge(B, C);
        graph.addEdge(B, D);
        graph.addEdge(D, C);
        graph.addEdge(E, C);
        graph.addEdge(C, F);
        TopSort topoSort = new TopSort(graph);
        topoSort.printRes();
    }

}

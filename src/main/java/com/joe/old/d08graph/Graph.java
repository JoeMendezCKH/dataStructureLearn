package com.joe.old.d08graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Joe
 * @create 2020/4/20 10:22
 */
public class Graph {

    /**
     * 存储的顶点集合
     */
    private ArrayList<String> vertexList;
    /**
     * 邻接矩阵
     */
    private int[][] edges;
    /**
     * 边的数目
     */
    private int numOfEdges;
    private boolean[] isVisited;

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    /**
     * @param index 当前节点的索引
     * @return 当前节点的第一个邻接节点的索引
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
     * @param v1 当前节点
     * @param v2 已访问的邻接节点的索引
     * @return 从 v2 开始的下一个邻接节点
     */
    public int getNextNeighbor(int v1, int v2) {
        for (int i = v2 + 1; i < vertexList.size(); i++) {
            if (edges[v1][i] > 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * @param isVisited 是否访问过的数组
     * @param index     节点索引
     */
    private void dfs(boolean[] isVisited, int index) {
        System.out.print(getValueByIndex(index) + " --> ");
        isVisited[index] = true;
        // 查找节点index 的第一个邻接节点 w
        int w = getFirstNeighbor(index);
        while (w != -1) {
            if (!isVisited[w]) {
                dfs(isVisited, w);
            } else {
                w = getNextNeighbor(index, w);
            }
        }
    }

    public void dfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                dfs(isVisited, i);
            }
        }
        initIsVisited(isVisited);
        System.out.println();
    }

    private void initIsVisited(boolean[] isVisited) {
        for (int i = 0; i < isVisited.length; i++) {
            isVisited[i] = false;
        }
    }

    public void bfs() {
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]) {
                bfs(isVisited, i);
            }
        }
        initIsVisited(isVisited);
        System.out.println();
    }

    /**
     * 只针对一个节点的bfs
     *
     * @param isVisited 访问数组
     * @param index     索引
     */
    private void bfs(boolean[] isVisited, int index) {
        // first index of queue
        int u;
        // neighbor node index
        int w;
        // sequence of node visit
        LinkedList<Integer> queue = new LinkedList<>();
        System.out.print(getValueByIndex(index) + "->");
        isVisited[index] = true;
        queue.addLast(index);
        while (!queue.isEmpty()) {
            u = queue.removeFirst();
            w = getFirstNeighbor(u);
            while (w != -1) {
                if (!isVisited[w]) {
                    System.out.print(getValueByIndex(w) + "->");
                    isVisited[w] = true;
                    queue.addLast(w);
                } else {
                    // 体现出 bfs
                    w = getNextNeighbor(u, w);
                }
            }
        }
    }

    /**
     * @param v1    第一个点的下标, 即第几个顶点
     * @param v2    第二个点的下标, 即第几个顶点
     * @param value 权值
     */
    public void insertEdge(int v1, int v2, int value) {
        edges[v1][v2] = value;
        edges[v2][v1] = value;
        numOfEdges++;
    }

    /**
     * @param index index of vertex
     * @return vertex value
     */
    public String getValueByIndex(int index) {
        return vertexList.get(index);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public void showGraph() {
        for (int[] edge : edges) {
            System.out.println(Arrays.toString(edge));
        }
    }
}

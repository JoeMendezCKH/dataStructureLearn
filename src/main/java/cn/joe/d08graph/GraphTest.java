package cn.joe.d08graph;

import org.junit.Test;

/**
 * @author Joe
 * @create 2020/4/20 10:30
 */
public class GraphTest {
    @Test
    public void test() {
        int n = 5;
        String[] vertex = {"A", "B", "C", "D", "E"};

        Graph graph = new Graph(n);
        for (String s : vertex) {
            graph.insertVertex(s);
        }
        // A-B
        graph.insertEdge(0, 1, 1);
        // A-C
        graph.insertEdge(0, 2, 1);
        // B-C
        graph.insertEdge(1, 2, 1);
        // B-D
        graph.insertEdge(1, 3, 1);
        // B-E
        graph.insertEdge(1, 4, 1);
//        graph.showGraph();

        System.out.println("dfs");
        graph.dfs();
        System.out.println("bfs");
        graph.bfs();
    }
}

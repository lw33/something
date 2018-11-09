package lw.learn.algorithm.graph;

import lw.learn.ds.DenseGraph;
import lw.learn.ds.Graph;
import lw.learn.ds.SparseGraph;
import lw.learn.utils.FileOperation;

import java.util.Iterator;

/**
 * @Author lw
 * @Date 2018-11-09 22:56:55
 *  连通分量
 **/
public class Component {

    private Graph graph;
    private boolean[] visited;
    private int count;

    public Component(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.V()];

        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        Iterator<Integer> iterator = graph.iterator(v);
        iterator.forEachRemaining(vertex -> {
                    if (!visited[vertex])
                        dfs(vertex);
                }
        );
    }

    public int count() {
        return count;
    }

    public static void main(String[] args) {
        DenseGraph denseGraph = new DenseGraph(13, true);
        FileOperation.readGrap(denseGraph, "g1.txt");
        Graph.printGraph(denseGraph);
        Component component = new Component(denseGraph);
        System.out.println(component.count());

        SparseGraph sparseGraph = new SparseGraph(7, true);
        FileOperation.readGrap(sparseGraph, "g2.txt");
        Graph.printGraph(sparseGraph);
        Component component2 = new Component(denseGraph);
        System.out.println(component2.count());
    }
}

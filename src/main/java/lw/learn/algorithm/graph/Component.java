package lw.learn.algorithm.graph;

import lw.learn.ds.DenseGraph;
import lw.learn.ds.Graph;
import lw.learn.ds.SparseGraph;
import lw.learn.utils.FileOperation;

import java.util.Arrays;
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
    private int[] id;

    public Component(Graph graph) {
        this.graph = graph;
        visited = new boolean[graph.V()];
        id = new int[graph.V()];
        Arrays.fill(id, -1);

        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        id[v] = count;
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

    public boolean isConnected(int v, int w) {
        return id[v] == id[w];
    }

    public void printIds() {
        System.out.println(Arrays.toString(id));
    }

    public static void main(String[] args) {
        Graph denseGraph = FileOperation.readGrap(DenseGraph.class, true, "g1.txt");
        Graph.printGraph(denseGraph);
        Component component = new Component(denseGraph);
        System.out.println(component.count());
        component.printIds();
        System.out.println(component.isConnected(1, 3));
        Graph sparseGraph = FileOperation.readGrap(SparseGraph.class, true, "g2.txt");
        Graph.printGraph(sparseGraph);
        Component component2 = new Component(sparseGraph);
        System.out.println(component2.count());
    }
}

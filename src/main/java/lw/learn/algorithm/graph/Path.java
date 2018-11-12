package lw.learn.algorithm.graph;

import lw.learn.ds.ArrayStack;
import lw.learn.ds.DenseGraph;
import lw.learn.ds.Graph;
import lw.learn.ds.Stack;
import lw.learn.utils.FileOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-10 13:11:06
 **/
public class Path {

    private Graph graph;
    private int s; // source
    private boolean[] visited;
    private int[] from;

    public Path(Graph graph, int s) {
        this.graph = graph;
        this.s = s;
        visited = new boolean[graph.V()];
        from = new int[graph.V()];
        Arrays.fill(from, -1);
        dfs(s);
    }

    private void dfs(int v) {
        visited[v] = true;
        graph.iterator(v).forEachRemaining(vertext -> {
            if (!visited[vertext]) {
                from[vertext] = v;
                dfs(vertext);
            }
        });
    }

    public boolean hasPath(int w) {
        return visited[w];
    }

    public void path(int w, List<Integer> paths) {
        Stack<Integer> stack = new ArrayStack<>();
        int p = w;
        while (p != -1) {
            stack.push(p);
            p = from[p];
        }
        while (!stack.isEmpty())
            paths.add(stack.pop());
    }

    public void showPath(int w) {
        List<Integer> path = new ArrayList<>();
        path(w, path);
        int i = 0;
        for (; i < path.size() - 1; i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println(path.get(i));
    }

    public static void main(String[] args) {
        Graph denseGraph = FileOperation.readGrap(DenseGraph.class, false, "g2.txt");
        Path path = new Path(denseGraph, 0);
        path.showPath(6);
    }
}

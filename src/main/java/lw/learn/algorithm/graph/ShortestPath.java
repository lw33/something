package lw.learn.algorithm.graph;

import lw.learn.ds.ArrayStack;
import lw.learn.ds.DenseGraph;
import lw.learn.ds.Graph;
import lw.learn.ds.Stack;
import lw.learn.utils.FileOperation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-10 13:53:17
 **/
public class ShortestPath {

    private Graph graph;
    private int s;
    private boolean[] visited;
    private int[] from;
    private int[] ord;

    public ShortestPath(Graph graph, int s) {
        this.graph = graph;
        this.s = s;
        visited = new boolean[graph.V()];
        from = new int[graph.V()];
        ord = new int[graph.V()];

        for (int i = 0; i < graph.V(); i++) {
            from[i] = -1;
            ord[i] = -1;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(s);
        ord[s] = 0;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            visited[poll] = true;
            graph.iterator(poll).forEachRemaining(v -> {
                if (!visited[v]) {
                    from[v] = poll;
                    ord[v] = ord[poll] + 1;
                    queue.offer(v);
                }
            });
        }
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

    public int length(int w){
        return ord[w];
    }
    public static void main(String[] args) {
        Graph denseGraph = FileOperation.readGrap(DenseGraph.class, false, "g2.txt");
        ShortestPath path = new ShortestPath(denseGraph, 0);
        path.showPath(6);
        System.out.println(path.length(6));
    }
}

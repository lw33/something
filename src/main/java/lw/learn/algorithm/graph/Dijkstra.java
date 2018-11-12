package lw.learn.algorithm.graph;


import lw.learn.ds.ArrayStack;
import lw.learn.ds.IndexHeap;
import lw.learn.ds.Merger;
import lw.learn.ds.Stack;
import lw.learn.ds.wg.Edge;
import lw.learn.ds.wg.SparseGraph;
import lw.learn.ds.wg.WeightGraph;
import lw.learn.utils.FileOperation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-12 17:12:25
 **/

public class Dijkstra<T extends Comparable<T>> {

    private WeightGraph<T> graph;
    private int source;            // 单源最短路径
    private T[] distTo;           // 源点到各顶点的距离
    private boolean[] marked;    // 已经求出最短路径的定点
    private List<Edge<T>> from; // 从那个顶点到达
    private Merger<T> merger;

    public Dijkstra(WeightGraph<T> graph, Comparator<T> comparator, Merger<T> merger, int source, T sWeight) {
        this.graph = graph;
        this.source = source;
        this.merger = merger;
        distTo = (T[]) new Comparable[graph.V()];
        marked = new boolean[graph.V()];
        from = new ArrayList<>();
        for (int i = 0; i < graph.V(); i++) {
            from.add(null);
        }
        IndexHeap<T> indexHeap = new IndexHeap<>(graph.V(), comparator);

        distTo[source] = sWeight;
        marked[source] = true;
        indexHeap.add(source, distTo[source]);

        while (!indexHeap.isEmpty()) {
            int v = indexHeap.popIndex();
            marked[v] = true;
            Iterator<Edge<T>> iterator = graph.iterator(v);

            iterator.forEachRemaining(e -> {
                int w = e.other(v);
                if (!marked[w]) {
                    T merge = merger.merge(distTo[v], e.weight());
                    if (from.get(w) == null || merge.compareTo(distTo[w]) < 0) {
                        distTo[w] = merge;
                        from.set(w, e);
                        if (indexHeap.contains(w))
                            indexHeap.change(w, distTo[w]);
                        else
                            indexHeap.add(w, distTo[w]);
                    }
                }
            });
        }
    }

    public boolean hasPath(int w) {
        return marked[w];
    }

    public List<Integer> path(int w) {
        Stack<Integer> stack = new ArrayStack<>();
        List<Integer> paths = new ArrayList<>();
        int p = w;
        while (p != source) {
            stack.push(p);
            p = from.get(p).other(p);
        }
        stack.push(source);
        while (!stack.isEmpty())
            paths.add(stack.pop());
        return paths;
    }

    public void showPath(int w) {
        List<Integer> path = path(w);
        int i = 0;
        for (; i < path.size() - 1; i++) {
            System.out.print(path.get(i) + "->");
        }
        System.out.println(path.get(i));
    }

    public T length(int w){
        return distTo[w];
    }

    public static void main(String[] args) {
        WeightGraph<Double> weightGraph = FileOperation.readWeightGrap(SparseGraph.class, false, "tg1.txt");

        Merger<Double> merger = (e1, e2) -> e1 + e2;
        Comparator<Double> comparator = (d1, d2) -> -d1.compareTo(d2);
        Dijkstra<Double> dijkstra = new Dijkstra<>(weightGraph, comparator, merger, 0, 0.0);
        for (int i = 1; i < weightGraph.V(); i++) {
            System.out.println("Shortest Path to " + i );
            dijkstra.showPath(i);
            System.out.println("==========================================");
        }
    }
}

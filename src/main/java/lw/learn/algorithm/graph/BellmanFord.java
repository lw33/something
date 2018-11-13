package lw.learn.algorithm.graph;

import lw.learn.ds.ArrayStack;
import lw.learn.ds.Stack;
import lw.learn.ds.wg.Edge;
import lw.learn.ds.wg.SparseGraph;
import lw.learn.ds.wg.WeightGraph;
import lw.learn.utils.FileOperation;
import lw.learn.utils.Merger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author lw
 * @Date 2018-11-12 20:09:20
 **/
public class BellmanFord<T extends Comparable<T>> {

    private WeightGraph<T> graph;
    private int source;
    private T[] disTo;
    private List<Edge<T>> from;
    private boolean hasNegativeCycle;
    private Merger<T> merger;

    public BellmanFord(WeightGraph<T> graph, Merger<T> merger, int source, T initWeight) {
        this.graph = graph;
        this.source = source;
        this.merger = merger;
        disTo = (T[]) new Comparable[graph.V()];
        disTo[source] = initWeight;
        from = new ArrayList<>(graph.V());
        for (int i = 0; i < graph.V(); i++) {
            from.add(null);
        }

        for (int i = 1; i < graph.V(); i++) {
            relaxation(source);
            for (int j = (source + 1) % graph.V(); j != source; j = (j + 1) % graph.V()) {
                relaxation(j);
            }
        }

        hasNegativeCycle = detectNegativeCycle();
    }

    private void relaxation(int j) {
        Iterator<Edge<T>> iterator = graph.iterator(j);
        int finalJ = j;
        iterator.forEachRemaining(e -> {
            T merge = merger.merge(e.weight(), disTo[finalJ]);
            if (from.get(e.w()) == null || merge.compareTo(disTo[e.other(finalJ)]) < 0) {
                disTo[e.w()] = merge;
                from.set(e.w(), e);
            }
        });
    }

    private boolean detectNegativeCycle() {
        AtomicBoolean res = new AtomicBoolean(false);
        for (int j = 0; j < graph.V(); j++) {
            Iterator<Edge<T>> iterator = graph.iterator(j);
            while (iterator.hasNext()) {
                Edge<T> e = iterator.next();
                T merge = merger.merge(e.weight(), disTo[j]);
                if (from.get(e.other(j)) == null || merge.compareTo(disTo[e.other(j)]) < 0)
                    return true;
            }
        }
        return res.get();
    }

    //public boolean hasPath(int w) {
    //    return marked[w];
    //}

    public List<Integer> path(int w) {
        Stack<Integer> stack;
        stack = new ArrayStack<>();
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

    public boolean hasNegativeCycle() {
        return hasNegativeCycle;
    }

    public static void main(String[] args) {
        WeightGraph<Double> weightGraph = FileOperation.readWeightGrap(SparseGraph.class, false, "tg1.txt");

        Merger<Double> merger = (e1, e2) -> e1 + e2;
        BellmanFord<Double> bellmanFord = new BellmanFord<>(weightGraph, merger, 0, 0.0);
        System.out.println(bellmanFord.hasNegativeCycle());
        for (int i = 1; i < weightGraph.V(); i++) {
            System.out.println("Shortest Path to " + i);
            bellmanFord.showPath(i);
            System.out.println("==========================================");
        }

    }
}

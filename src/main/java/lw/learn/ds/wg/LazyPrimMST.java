package lw.learn.ds.wg;


import lw.learn.ds.Merger;
import lw.learn.utils.FileOperation;

import java.util.*;

/**
 * @Author lw
 * @Date 2018-11-10 16:27:50
 **/
public class LazyPrimMST<T> {

    private WeightGraph<T> graph;
    private PriorityQueue<Edge<T>> priorityQueue;
    private boolean[] marked;
    private T mstWeight;
    private List<Edge<T>> mst;
    private Merger<T> merger;


    /**
     *
     * @param graph
     * @param merger
     * @param comparator
     * @param mstInit
     */
    public LazyPrimMST(WeightGraph<T> graph, Merger<T> merger, Comparator<Edge<T>> comparator, T mstInit) {
        this.mstWeight = mstInit;
        this.merger = merger;
        this.graph = graph;
        this.marked = new boolean[graph.V()];
        priorityQueue = new PriorityQueue<>(comparator);
        mst = new ArrayList<>();
        visit(0);
        while (!priorityQueue.isEmpty()) {
            Edge<T> poll = priorityQueue.poll();
            if (marked[poll.v()] == marked[poll.w()])
                continue;
            mst.add(poll);
            mstWeight = merger.meger(poll.weight(), mstWeight);
            if (!marked[poll.v()])
                visit(poll.v());
            else
                visit(poll.w());
        }
    }

    private void visit(int v) {
        if (!marked[v]) {
            marked[v] = true;
            Iterator<Edge<T>> iterator = graph.iterator(v);
            iterator.forEachRemaining(edg -> {
                if (!marked[edg.other(v)])
                    priorityQueue.offer(edg);
            });
        }
    }

    public T mstWeight() {
        return mstWeight;
    }

    public List<Edge<T>> mst() {
        return mst;
    }

    public static void main(String[] args) {
        WeightGraph<Double> weightGraph = FileOperation.readWeightGrap(SparseGraph.class, false, "wg1.txt");
        LazyPrimMST<Double> primeMST = new LazyPrimMST<>(weightGraph, (e1, e2) -> e1 + e2, (edg1, edg2) -> edg1.weight().equals(edg2.weight()) ? 0 : edg1.weight() > edg2.weight() ? 1 : -1, 0.0);
        for (Edge<Double> doubleEdge : primeMST.mst()) {
            System.out.print(doubleEdge.v() + "--" + doubleEdge.w() + ": " + doubleEdge.weight());
            System.out.println();
        }
        System.out.println(primeMST.mstWeight());
    }
}

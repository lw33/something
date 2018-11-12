package lw.learn.ds.wg;

import lw.learn.ds.IndexHeap;
import lw.learn.ds.Merger;
import lw.learn.utils.FileOperation;

import java.util.*;

/**
 * @Author lw
 * @Date 2018-11-10 20:14:42
 **/
public class PrimMST<T extends Comparable<T>> {

    private WeightGraph<T> graph;
    private IndexHeap<T> indexHeap;
    private boolean[] marked;
    private T mstWeight;
    private List<Edge<T>> mst;
    private List<Edge<T>> edgeTo;
    private Merger<T> merger;

    public PrimMST(WeightGraph<T> graph, Comparator<T> comparator, Merger<T> merger, T mstInit) {
        this.graph = graph;
        this.merger = merger;
        mstWeight = mstInit;
        indexHeap = new IndexHeap<>(graph.V(), comparator);
        marked = new boolean[graph.V()];
        mst = new ArrayList<>();
        edgeTo = new ArrayList<>(graph.V());
        for (int i = 0; i < graph.V(); i++) {
            edgeTo.add(null);
        }

        visit(0);

        while (!indexHeap.isEmpty()) {
            int v = indexHeap.popIndex();
            mst.add(edgeTo.get(v));
            mstWeight = merger.meger(mstWeight, edgeTo.get(v).weight());
            visit(v);
        }
    }

    private void visit(int v) {

        if (!marked[v]) {
            marked[v] = true;
            Iterator<Edge<T>> iterator = graph.iterator(v);
            iterator.forEachRemaining(e -> {
                int w = e.other(v);
                if (!marked[w]) {
                    if (edgeTo.get(w) == null) {
                        indexHeap.add(w, e.weight());
                        edgeTo.set(w, e);
                    } else if (edgeTo.get(w).weight().compareTo(e.weight()) > 0) {
                        edgeTo.set(w, e);
                        indexHeap.change(w, e.weight());
                    }
                }
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
        PrimMST<Double> primeMST = new PrimMST<>(weightGraph, (d1, d2) -> -d1.compareTo(d2), (e1, e2) -> e1 + e2, 0.0);
        for (Edge<Double> doubleEdge : primeMST.mst()) {
            System.out.print(doubleEdge.v() + "--" + doubleEdge.w() + ": " + doubleEdge.weight());
            System.out.println();
        }
        System.out.println(primeMST.mstWeight());
    }
}

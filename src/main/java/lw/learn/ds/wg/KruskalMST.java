package lw.learn.ds.wg;

import lw.learn.algorithm.sort.sort2.Merge;
import lw.learn.ds.Merger;
import lw.learn.ds.UnionFind;

import java.util.*;
import java.util.function.Consumer;

/**
 * @Author lw
 * @Date 2018-11-12 16:00:20
 **/
public class KruskalMST<T> {

    private List<Edge<T>> mst;
    private T mstWeigth;
    private Merger<T> merger;

    public KruskalMST(WeightGraph<T> graph, Comparator<Edge<T>> comparator, Merger<T> merger, T initWeight) {

        mstWeigth = initWeight;
        this.merger = merger;
        PriorityQueue<Edge<T>> priorityQueue = new PriorityQueue<>(comparator);
        mst = new ArrayList<>();
        for (int i = 0; i < graph.V(); i++) {
            graph.iterator(i)
                    .forEachRemaining(e -> {
                        if (e.v() < e.w())
                            priorityQueue.add(e);

                    });
        }
        UnionFind unionFind = new UnionFind(graph.V());

        while (!priorityQueue.isEmpty() && mst.size() < graph.V()) {
            Edge<T> edg = priorityQueue.poll();
            if (unionFind.isConnected(edg.v(), edg.w()))
                continue;

            mst.add(edg);
            mstWeigth = merger.meger(mstWeigth, edg.weight());
            unionFind.union(edg.w(), edg.v());
        }
    }

    public T mstWeight() {
        return mstWeigth;
    }

    public List<Edge<T>> mst() {
        return mst;
    }

    public static void main(String[] args) {

    }
}

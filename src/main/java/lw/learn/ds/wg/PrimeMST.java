package lw.learn.ds.wg;

import lw.learn.ds.Merger;

import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author lw
 * @Date 2018-11-10 20:14:42
 **/
public class PrimeMST<T> {

    private WeightGraph<T> graph;
    private PriorityQueue<Edge<T>> priorityQueue;
    private boolean[] marked;
    private T mstWeight;
    private List<Edge<T>> mst;
    private Merger<T> merger;
}

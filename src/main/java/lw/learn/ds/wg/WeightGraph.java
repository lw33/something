package lw.learn.ds.wg;

import java.util.Iterator;

/**
 * @Author lw
 * @Date 2018-11-10 15:05:36
 **/
public interface WeightGraph<T> {

    int V();

    int E();

    void addEdge(int v, int w, T weight);

    Iterator<Edge<T>> iterator(int v);

    static void printGraph(WeightGraph<?> graph) {
        System.out.println(graph.V() + " vertexes -> ");
        for (int i = 0; i < graph.V(); i++) {
            System.out.print(i + ": ");
            graph.iterator(i).forEachRemaining(w -> System.out.print(w + " "));
            System.out.println();
        }
    }
}

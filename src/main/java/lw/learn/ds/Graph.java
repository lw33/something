package lw.learn.ds;

import java.util.Iterator;
/**
 * @Author lw
 * @Date 2018-11-09 22:54:44
 **/
public interface Graph {

    void addEdge(int v, int w);

    int V();

    int E();

    Iterator<Integer> iterator(int v);

    static void printGraph(Graph graph) {
        System.out.println(graph.V());
        for (int i = 0; i < graph.V(); i++) {
            System.out.print(i + ": ");
            graph.iterator(i).forEachRemaining(w -> System.out.print(w + " "));
            System.out.println();
        }
    }
}

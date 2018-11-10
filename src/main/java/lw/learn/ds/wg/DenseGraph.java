package lw.learn.ds.wg;

import lw.learn.utils.FileOperation;

import java.util.Iterator;

/**
 * @Author lw
 * @Date 2018-11-09 21:30:52
 **/
public class DenseGraph<T> implements WeightGraph<T> {

    private int n;   // vertex
    private int m;   // edge
    private boolean directed;
    private Edge[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        g = new Edge[n][n];
    }


    public void addEdge(int v, int w, T weight) {

        if (hasEdge(v, w)) {
            g[v][w] = null;
            if (!directed)
                g[w][v] = null;
            m--;
        }

        g[v][w] = new Edge(v, w, weight);
        if (!directed) {
            g[w][v] = new Edge(w, v, weight);
        }
        m++;
    }

    public int V() {
        return n;
    }

    public int E() {
        return m;
    }

    private boolean hasEdge(int v, int w) {
        checkV(v, w);
        return g[v][w] != null;
    }

    private void checkV(int... v) {
        for (int i : v)
            if (i < 0 || i >= n)
                throw new IllegalArgumentException("illegal vertex");
    }

    private class adjIterator implements Iterator<Edge<T>> {

        private int v;
        private int index;

        public adjIterator(int v) {
            this.v = v;
            this.index = -1;
        }

        @Override
        public boolean hasNext() {
            for (int i = index; i < V() -1; i++) {
                if (g[v][++index] != null)
                    return true;
            }

            return false;
        }

        @Override
        public Edge<T> next() {
            return g[v][index];
        }
    }

    public Iterator<Edge<T>> iterator(int v) {
        return new adjIterator(v);
    }

    public static void main(String[] args) {
        DenseGraph<Double> doubleDenseGraph = (DenseGraph<Double>) FileOperation.readWeightGrap(DenseGraph.class, false, "wg1.txt");
        WeightGraph.printGraph(doubleDenseGraph);

        WeightGraph<Double> weightGraph = FileOperation.readWeightGrap(SparseGraph.class, false, "wg1.txt");
        WeightGraph.printGraph(weightGraph);
    }
}

package lw.learn.ds;

import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * @Author lw
 * @Date 2018-11-09 21:30:52
 **/
public class DenseGraph implements Graph{

    private int n;   // vertex
    private int m;   // edge
    private boolean directed;
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        g = new boolean[n][n];
    }


    public void addEdge(int v, int w) {

        if (hasEdge(v, w))
            return;

        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
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
        return g[v][w];
    }

    private void checkV(int... v) {
        for (int i : v)
            if (i < 0 || i >= n)
                throw new IllegalArgumentException("illegal vertex");
    }

    private class adjIterator implements Iterator<Integer> {

        private int v;
        private int index;

        public adjIterator(int v) {
            this.v = v;
            this.index = -1;
        }

        @Override
        public boolean hasNext() {
            for (int i = index; i < V() -1; i++) {
                if (g[v][++index])
                    return true;
            }

            return false;
        }

        @Override
        public Integer next() {
            return index;
        }
    }

    public Iterator<Integer> iterator(int v) {
        return new adjIterator(v);
    }
}

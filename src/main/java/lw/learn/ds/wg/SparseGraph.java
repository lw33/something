package lw.learn.ds.wg;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


/**
 * @Author lw
 * @Date 2018-11-09 21:37:56
 **/
public class SparseGraph<T> implements WeightGraph<T> {

    private int n;   // vertex
    private int m;   // edge
    private boolean directed;
    private ArrayList<LinkedList<Edge<T>>> g;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new LinkedList<>());
        }
    }

    public int V() {
        return n;
    }

    public int E() {
        return m;
    }

    public void addEdge(int v, int w, T weight) {
        if (hasEdge(v, w))
            return;
        g.get(v).add(new Edge<>(v, w, weight));
        if (v != w && !directed)
            g.get(w).add(new Edge<>(w, v, weight));
        m++;
    }

    private boolean hasEdge(int v, int w) {
        checkV(v, w);
        for (int i = 0; i < g.get(v).size(); i++)
            if (g.get(v).get(i).other(v) == w)
                return true;

        return false;
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
        }

        @Override
        public boolean hasNext() {
            return g.get(v).size() > index;
        }

        @Override
        public Edge<T> next() {
            Edge<T> edg = g.get(v).get(index);
            index++;
            return edg;
        }
    }

    public Iterator<Edge<T>> iterator(int v) {
        return new adjIterator(v);
    }
}

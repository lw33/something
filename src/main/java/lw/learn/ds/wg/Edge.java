package lw.learn.ds.wg;

/**
 * @Author lw
 * @Date 2018-11-10 14:28:42
 **/
public class Edge<T> {

    private int v;
    private int w;
    private T weight;

    public Edge(int v, int w, T weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int v() {
        return v;
    }

    public int w() {
        return w;
    }

    public T weight() {
        return weight;
    }

    public int other(int v) {
        return this.v == v ? this.w : this.v;
    }

    @Override
    public String toString() {
        return "Edge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }
}

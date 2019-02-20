package lw.learn.nk.mock.f1.p3;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // 点数
        int M = in.nextInt(); // 边数
        int S = in.nextInt(); // 源点
        int T = in.nextInt(); // 目标点

        WeightSparseGraph graph = new WeightSparseGraph(N + 1, true);

        for (int i = 0; i < M; i++) {
            int v = in.nextInt();
            int w = in.nextInt();
            int weight = in.nextInt();
            graph.addEdge(v, w, weight);
        }

        System.out.println(path(graph, S, T) + path(graph, T, S));
    }

    public static class Edge {
        private int v;
        private int w;

        private int weight;

        public Edge(int v, int w, int weight) {
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

        public int weight() {
            return weight;
        }

        public int other(int x) {

            return x == v ? w : v;
        }
    }

    public static class WeightSparseGraph {

        private int n;
        private int m;
        private boolean directed;
        private List<List<Edge>> g;

        public WeightSparseGraph(int n, boolean directed) {
            this.n = n;
            this.directed = directed;
            g = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                g.add(new ArrayList<>());
            }
        }

        public int V() {
            return n;
        }

        public int E() {
            return m;
        }

        public void addEdge(int v, int w, int weight) {
            if (hasPath(v, w)) {
                --m;
            }
            g.get(v).add(new Edge(v, w, weight));
            if (!directed) {
                g.get(w).add(new Edge(w, v, weight));
            }
            m++;
        }

        public boolean hasPath(int v, int w) {
            for (Edge edge : g.get(v)) {
                if (edge.w() == w) {
                    return true;
                }
            }
            return false;
        }

        class AdjIterator implements Iterator<Edge> {

            private int index;
            private int v;

            public AdjIterator(int v) {
                this.v = v;
            }

            @Override
            public boolean hasNext() {

                return g.get(v).size() > index;
            }

            @Override
            public Edge next() {

                return g.get(v).get(index++);
            }

        }

        public Iterator<Edge> iterator(int v) {
            return new AdjIterator(v);
        }
    }

    public static int path(WeightSparseGraph g, int s, int t) {
        int[] distinto;           // 源点到各顶点的距离
        boolean[] marked;    // 已经求出最短路径的定点
        Edge[] from; // 从那个顶点到达
        distinto = new int[g.V()];
        marked = new boolean[g.V()];
        from = new Edge[g.V()];
        IndexHeap ipq = new IndexHeap(g.V());
        ipq.add(s, distinto[s]);
        while (!ipq.isEmpty()) {
            int v = ipq.pollIndex();
            marked[v] = true;
            g.iterator(v).forEachRemaining(edge -> {
                int w = edge.other(v);
                if (!marked[w]) {
                    int newWeight = distinto[v] + edge.weight();
                    if (from[w] == null || newWeight < distinto[w]) {
                        distinto[w] = newWeight;
                        from[w] = edge;
                        if (ipq.contains(w)) {
                            ipq.change(w, distinto[w]);
                        } else {
                            ipq.add(w, distinto[w]);
                        }
                    }
                }
            });
        }
        return distinto[t];
    }

    public static class IndexHeap {

        private int[] data;
        private int[] indexes;
        private int[] reverse;
        private int size;

        public IndexHeap(int capacity) {
            data = new int[capacity];
            indexes = new int[capacity];
            reverse = new int[capacity];
            for (int i = 0; i < capacity; i++) {
                indexes[i] = -1;
                reverse[i] = -1;
            }
        }

        public void add(int i, int e) {

            data[i] = e;
            indexes[size] = i;
            reverse[i] = size;

            shiftUp(size);
            size++;
        }

        public void change(int i, int e) {

            data[i] = e;
            int j = reverse[i];
            shiftUp(j);
            shiftDown(j);
        }

        public int pollIndex() {

            int maxIndex = indexes[0];
            size--;
            indexes[0] = indexes[size];
            reverse[indexes[0]] = 0;
            reverse[indexes[size]] = 0;
            shiftDown(0);
            return maxIndex;
        }


        public int peek() {
            return elementData(indexes[0]);
        }

        private void shiftUp(int k) {
            int x = indexes[k];
            while (k > 0) {
                int parent = parent(k);
                int parentIndex = indexes[parent];
                if (elementData(x) <= elementData(parentIndex)) {
                    break;
                }
                indexes[k] = parentIndex;
                reverse[parentIndex] = k;
                k = parent;
            }
            indexes[k] = x;
            reverse[x] = k;
        }


        private void shiftDown(int k) {
            int x = indexes[k];
            int i;
            while ((i = left(k)) < size) {
                if (i + 1 < size &&
                        elementData(indexes[i]) < elementData(indexes[i + 1])) {
                    ++i;
                }

                if (elementData(x) >= elementData(indexes[i])) {
                    break;
                }
                indexes[k] = indexes[i];
                reverse[indexes[i]] = k;
                k = i;
            }

            indexes[k] = x;
            reverse[x] = k;
        }


        int elementData(int index) {
            return data[index];
        }


        public boolean isEmpty() {
            return size == 0;
        }

        private int parent(int i) {
            return (i - 1) >>> 1;
        }

        private int left(int i) {
            return (i << 1) + 1;
        }

        public boolean contains(int i) {
            return reverse[i] != -1;
        }

    }
}

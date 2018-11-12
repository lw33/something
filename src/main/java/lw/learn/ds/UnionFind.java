package lw.learn.ds;

/**
 * @Author lw
 * @Date 2018-11-12 15:39:35
 **/
public class UnionFind {

    private int[] parent;
    private int[] rank;
    private int count;


    public UnionFind(int count) {
        this.count = count;
        parent = new int[count];
        rank = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int p) {
        int i = 0;
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
            if (p != parent[p]) {
                i++;
            }
        }
        rank[p] -= i;
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot)
            return;

        if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else {
            parent[pRoot] = qRoot;
            rank[qRoot]++;
        }
    }
}

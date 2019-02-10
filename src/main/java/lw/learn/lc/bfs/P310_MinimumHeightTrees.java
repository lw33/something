package lw.learn.lc.bfs;

import lw.learn.utils.JSON2Java;
import org.junit.Test;

import java.util.*;

/**
 * @Author lw
 * @Date 2019-02-10 20:52:53
 **/
public class P310_MinimumHeightTrees {

    int n;
    List<List<Integer>> g;

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        if (n == 1) {
            return Arrays.asList(0);
        }
        this.n = n;
        g = new ArrayList<>(n);

        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }

        buildGraph(g, edges);

        int min = Integer.MAX_VALUE;
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!g.get(i).isEmpty()) {
                int h = bfs(i);
                if (h < min) {
                    res.clear();
                    res.add(i);
                    min = h;
                } else if (h == min) {
                    res.add(i);
                }
            }
        }

        return res;
    }

    private void buildGraph(List<List<Integer>> g, int[][] edges) {
        for (int[] edge : edges) {
            g.get(edge[0]).add(edge[1]);
            g.get(edge[1]).add(edge[0]);
        }
    }

    private int bfs(int s) {
        boolean[] visited = new boolean[n];
        int[] h = new int[n];
        int maxH = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visited[s] = true;
        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            int nextH = h[v] + 1;
            for (Integer w : g.get(v)) {
                if (!visited[w]) {
                    queue.offer(w);
                    visited[w] = true;
                    h[w] = nextH;
                    maxH = Math.max(h[w], maxH);
                }
            }
        }
        return maxH;
    }

    @Test
    public void test() {
        int[][] arr = JSON2Java.json2int2Array("[[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]");
        int n = 6;
        System.out.println(this.findMinHeightTrees(n, arr));
    }
}

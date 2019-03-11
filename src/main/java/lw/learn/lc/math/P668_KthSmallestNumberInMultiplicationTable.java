package lw.learn.lc.math;

import org.junit.Test;

import java.util.PriorityQueue;

/**
 * @Author lw
 * @Date 2019-03-10 22:48:51
 **/
public class P668_KthSmallestNumberInMultiplicationTable {

    public int findKthNumber(int m, int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int val = i * j;
                if (pq.size() < k) {
                    pq.add(val);
                } else {
                    if (pq.peek() > val) {
                        pq.poll();
                        pq.add(val);
                    }
                }
            }
        }
        return pq.peek();
    }

    public int findKthNumberII(int m, int n, int k) {
        int r = m * n;
        int l = 1;
        while (l <= r) {

            int mid = (l + r) / 2;
            int sum = 0;
            for (int i = 1; i <= n; i++) {
                if (mid < i) {
                    break;
                }
                sum += Math.min(m, mid / i);
            }

            if (sum < k) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    @Test
    public void test() {
        int m = 5;
        int n = 5;
        int k = 20;
        System.out.println(findKthNumberII(m, n, k));
    }

}

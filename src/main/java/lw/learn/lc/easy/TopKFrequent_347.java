package lw.learn.lc.easy;
import org.jetbrains.annotations.NotNull;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author lw
 * @Date 2018-11-05 22:32:35
 **/
public class TopKFrequent_347 {

    private class Frequence implements Comparable<Frequence> {
        int e, freq;

        public Frequence(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Frequence o) {
            if (this.freq < o.freq) {
                return -1;
            } else if (this.freq > o.freq) {
                return 1;
            } else {
                return 0;
            }

        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Frequence> pq = new PriorityQueue<>();
        map.forEach((key, value) -> {
            if (pq.size() < k) {
                pq.offer(new Frequence(key, value));
            } else {
                if (pq.peek().freq < value) {
                    pq.poll();
                    pq.offer(new Frequence(key, value));
                }
            }
        });

        java.util.LinkedList<Integer> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll().e);
        }
        return list;
    }

    @Test
    public void test() {

        int[] arr = {4, 1, -1, 2, -1, 2, 3};
        System.out.println(this.topKFrequent(arr, 2));
    }
}

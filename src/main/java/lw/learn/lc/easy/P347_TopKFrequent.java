package lw.learn.lc.easy;

import org.junit.Test;

import java.util.*;

/**
 * @Author lw
 * @Date 2018-11-05 22:32:35
 **/
public class P347_TopKFrequent {

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
    public List<Integer> topKFrequent2(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparing(map::get));
        map.forEach((key, value) -> {
            if (pq.size() < k) {
                pq.add(key);
            } else {
                if (map.get(pq.peek()) < value) {
                    pq.poll();
                    pq.add(key);
                }
            }
        });

        LinkedList<Integer> list = new LinkedList<>();
        while (!pq.isEmpty()) {
            list.addFirst(pq.poll());
        }

        return list;
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

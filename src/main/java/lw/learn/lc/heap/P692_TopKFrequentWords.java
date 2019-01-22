package lw.learn.lc.heap;

import org.junit.Test;

import java.util.*;

/**
 * @Author lw
 * @Date 2019-01-22 22:25:25
 **/
public class P692_TopKFrequentWords {
    
    class Node implements Comparable<Node>{
        int freq;
        String word;

        public Node(int freq, String word) {
            this.freq = freq;
            this.word = word;
        }

        public int getFreq() {
            return freq;
        }

        @Override
        public int compareTo(Node o) {
            if (this.freq != o.freq) {
                return Integer.compare(this.freq, o.freq);
            } else {
                return o.word.compareTo(this.word);
            }
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0 || k == 0) {
            return res;
        }
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        map.forEach((word, freq) -> {
            if (pq.size() < k) {
                pq.add(new Node(freq, word));
            } else {
                if (pq.peek().freq <= freq) {
                    if (pq.peek().freq < freq || word.compareTo(pq.peek().word) < 0) {
                        pq.poll();
                        pq.add(new Node(freq, word));
                    }
                }
            } 
        });
        while (!pq.isEmpty()) {
            res.add(pq.poll().word);
        }
        Collections.reverse(res);
        return res;
    }
    
    @Test
    public void test() {
        //String[] strings = {"i", "love", "leetcode", "i", "love", "coding"};
        String[] strings = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        //String[] strings = {"aa", "aaa", "a"};
        System.out.println(this.topKFrequent(strings, 4));
    }
}

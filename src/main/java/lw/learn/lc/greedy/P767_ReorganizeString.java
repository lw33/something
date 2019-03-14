package lw.learn.lc.greedy;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Author lw
 * @Date 2019-03-13 23:47:31
 **/
public class P767_ReorganizeString {

    class Node {
        char aChar;
        int freq;

        public Node(char aChar, int freq) {
            this.aChar = aChar;
            this.freq = freq;
        }
    }

    public String reorganizeString(String S) {
        char[] chars = S.toCharArray();
        int[] map = new int[26];
        int max = 0;
        for (char aChar : chars) {
            map[aChar - 'a']++;
            max = Math.max(map[aChar - 'a'], max);
        }
        int half = chars.length / 2;
        if (chars.length % 2 == 1) {
            half++;
        }
        if (max > half) {
            return "";
        }
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(a -> -a.freq));
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                pq.add(new Node((char) (i + 'a'), map[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        Node preNode = pq.poll();
        sb.append(preNode.aChar);
        while (!pq.isEmpty()) {
            Node node = pq.poll();
            sb.append(node.aChar);
            if (preNode.freq > 1) {
                preNode.freq = preNode.freq - 1;
                pq.add(preNode);
            }
            preNode = node;
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String str = "vlo";
        System.out.println(this.reorganizeString(str));
    }
}

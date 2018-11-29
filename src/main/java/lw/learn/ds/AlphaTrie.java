package lw.learn.ds;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author lw
 * @Date 2018-11-29 12:26:11
 **/
public class AlphaTrie {
    
    class Node {
        int cnt = 0;
        Node[] next = new Node[26];
    }

    Node root = new Node();

    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = char2index(word.charAt(i));
            if (cur.next[index] == null) {
                cur.next[index] = new Node();
            }
            cur = cur.next[index];
        }
        cur.cnt++;
    }

    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = char2index(word.charAt(i));
            if (cur.next[index] == null)
                return false;
            cur = cur.next[index];
        }
        return cur.cnt != 0;
    }

    public boolean prefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = char2index(prefix.charAt(i));
            if (cur.next[index] == null)
                return false;
            cur = cur.next[index];
        }
        return true;
    }

    private int char2index(char c) {
        return c - 'a';
    }

    @Test
    public void test() {
        Node node = new Node();
        System.out.println(Arrays.toString(node.next));
    }
}

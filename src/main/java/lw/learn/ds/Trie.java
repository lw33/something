package lw.learn.ds;

import java.util.HashMap;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-06 16:27:01
 **/
public class Trie {


    private class Node {

        boolean isWord;
        HashMap<Character, Node> next;

        Node(boolean isKeyword) {
            this.isWord = isKeyword;
            this.next = new HashMap<>();
        }

        Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int size() {
        return size;
    }

    public void add(String words) {

        Node cur = root;
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }

    }

    public boolean contains(String words) {

        Node cur = root;
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }

        return cur.isWord;
    }

    public boolean isPrefix(String prefix) {
        Node cur = root;

        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null)
                return false;

            cur = cur.next.get(c);
        }
        return true;
    }

}

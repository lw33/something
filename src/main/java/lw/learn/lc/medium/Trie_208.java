package lw.learn.lc.medium;

import java.util.HashMap;

/**
 * @Author lw
 * @Date 2018-11-06 17:43:31
 **/
public class Trie_208 {
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

    public Trie_208() {
        root = new Node();
    }



    public void insert(String words) {

        Node cur = root;
        for (int i = 0; i < words.length(); i++) {
            char c = words.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        cur.isWord = true;

    }

    public boolean search(String words) {

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

    public boolean startsWith(String prefix) {
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

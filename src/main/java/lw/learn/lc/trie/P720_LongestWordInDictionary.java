package lw.learn.lc.trie;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-28 22:46:48
 **/
public class P720_LongestWordInDictionary {

    class Node {
        boolean isWord;
        char c;
        Node[] next = new Node[26];

        public Node(char c) {
            this.c = c;
        }

        public Node() {
        }
    }

    private Node root = new Node();

    public void add(String word) {
        char[] chars = word.toCharArray();
        Node cur = root;
        for (char aChar : chars) {
            int index = aChar - 'a';
            Node node = cur.next[index];
            if (node == null) {
                cur.next[index] = node = new Node(aChar);
            }
            cur = node;
        }
        cur.isWord = true;
    }

    public void longestWord(Node node, StringBuilder sb, StringBuilder res) {

        boolean end = true;
        for (Node trieNode : node.next) {
            if (trieNode != null && trieNode.isWord) {
                end = false;
                    sb.append(trieNode.c);
                    longestWord(trieNode, sb, res);
                    sb.deleteCharAt(sb.length() - 1);
            }
        }
        if (end) {
            if (node.isWord) {
                if (sb.length() > res.length()) {
                    res.delete(0, res.length());
                    res.append(sb);
                } else if (sb.length() == res.length()) {
                    if (res.toString().compareTo(sb.toString()) > 0) {
                        res.delete(0, res.length());
                        res.append(sb);
                    }
                }
            }
        }
    }

    public String longestWord(String[] words) {
        for (String word : words) {
            add(word);
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        longestWord(root, sb, res);
        return res.toString();
    }

    @Test
    public void test() {
        String[] words = {"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"};
        System.out.println(this.longestWord(words));

    }
}

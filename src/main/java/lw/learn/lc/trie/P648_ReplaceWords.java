package lw.learn.lc.trie;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2019-01-28 23:37:31
 **/
public class P648_ReplaceWords {

    class Node {
        boolean isWord;
        Node[] next = new Node[26];

    }

    Node root = new Node();

    private void add(String word) {
        char[] chars = word.toCharArray();
        Node cur = root;
        for (char aChar : chars) {
            int index = aChar - 'a';
            Node node = cur.next[index];
            if (node == null) {
                cur.next[index] = node = new Node();
            }
            if (cur.isWord)
                break;
            cur = node;
        }
        cur.isWord = true;
    }

    private String prefix(String word) {
        char[] chars = word.toCharArray();
        Node cur = root;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            Node node = cur.next[index];
            if (node == null) {
                return word;
            }
            if (node.isWord) {
                return word.substring(0, i + 1);
            }
            cur = node;
        }
        return word;
    }

    public String replaceWords(List<String> dict, String sentence) {
        for (String s : dict) {
            add(s);
        }
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(prefix(word));
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Test
    public void test() {
        List<String> dict = new LinkedList<>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dict, sentence));
    }
}

package lw.learn.lc.design;

/**
 * @Author lw
 * @Date 2019-01-28 20:32:31
 **/
public class P211_AddAndSearchWordDataStructureDesign {

    class WordDictionary {

        class Node {
            boolean isWord;
            Node[] next = new Node[26];
        }

        private Node root = new Node();

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            char[] chars = word.toCharArray();
            Node cur = root;
            for (char aChar : chars) {
                Node node = cur.next[aChar-'a'];
                if (node == null)
                    cur.next[aChar-'a'] = node = new Node();
                cur = node;
            }
            cur.isWord = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return search(root, word.toCharArray(), 0);
        }

        public boolean search(Node node, char[] word, int index) {
            if (index == word.length) {
                return node.isWord;
            }
            char c = word[index];
            if (c == '.') {
                for (Node trieNode : node.next) {
                    if (trieNode != null && search(trieNode, word, index + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                return node.next[c - 'a'] != null && search(node.next[c - 'a'], word, index + 1);
            }
        }

    }
}

package lw.learn.lc.trie;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-28 21:48:36
 **/
public class P676_ImplementMagicDictionary {

    class MagicDictionary {

        class Node {
            boolean isWord;
            Node[] next = new Node[26];
        }

        private Node root = new Node();

        /**
         * Initialize your data structure here.
         */
        public MagicDictionary() {

        }

        /**
         * Build a dictionary through a list of words
         */
        public void buildDict(String[] dict) {
            for (String s : dict) {
                add(s);
            }
        }

        private void add(String word) {
            char[] chars = word.toCharArray();
            Node cur = root;
            for (char aChar : chars) {
                int index = aChar - 'a';
                Node node = cur.next[index];
                if (node == null)
                    cur.next[index] = node = new Node();
                cur = node;
            }
            cur.isWord = true;
        }

        /**
         * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
         */
        public boolean search(String word) {

            return search(root, word.toCharArray(), false, 0);
        }

        /**
         * 递归找到 一个不同的单词
         * @param node
         * @param word
         * @param hasWrong
         * @param index
         * @return
         */
        private boolean search(Node node, char[] word, boolean hasWrong, int index) {
            if (index == word.length) {
                return node.isWord && hasWrong;
            }
            char c = word[index];
            int i = c - 'a';
            boolean res = false;
            // 存在可直接在这个字符基础上往下找
            if (node.next[i] != null) {
                res = search(node.next[i], word, hasWrong, index + 1);
            }

            if (!hasWrong) {
                // 遍历下一层所有节点
                for (Node trieNode : node.next) {
                    // 去掉为空 去掉相同情况
                    if (trieNode != null && trieNode != node.next[i]
                            && search(trieNode, word, true, index + 1)) {
                        return true;
                    }
                }
            }
            return res;
        }
    }

    @Test
    public void test() {
        MagicDictionary dictionary = new MagicDictionary();
        String[] strings = {"hello", "leetcode"};
        dictionary.buildDict(strings);
        System.out.println(dictionary.search("hello"));
        System.out.println(dictionary.search("hhllo"));
        System.out.println(dictionary.search("hell"));
        System.out.println(dictionary.search("leetcoded"));

    }
}

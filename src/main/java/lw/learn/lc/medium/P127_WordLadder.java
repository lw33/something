package lw.learn.lc.medium;

import lw.learn.algorithm.graph.ShortestPath;
import lw.learn.ds.DenseGraph;
import lw.learn.ds.Graph;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-20 23:10:14
 **/
public class P127_WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        int index = 0;
        for (; index < wordList.size(); index++) {
            if (wordList.get(index).equals(endWord)) {
                break;
            }
        }
        if (index == wordList.size()) {
            return 0;
        }
        wordList.add(beginWord);

        Graph graph = new DenseGraph(wordList.size(), false);

        for (int i = 0; i < wordList.size(); i++) {
            String v = wordList.get(i);
            for (int j = 0; j < wordList.size(); j++) {
                int cnt = 0;
                if (i != j) {
                    String w = wordList.get(j);
                    if (v.length() == w.length()) {
                        for (int k = 0; k < w.length(); k++) {
                            if (v.charAt(k) != w.charAt(k)) {
                                cnt++;
                            }
                        }
                        if (cnt == 1) {
                            graph.addEdge(i, j);
                        }
                    }
                }
            }
        }
        ShortestPath shortestPath = new ShortestPath(graph, wordList.size()-1);
        int length = shortestPath.length(index);
        shortestPath.showPath(index);
        return length == -1 ? 0 : length + 1;
    }

    @Test
    public void test() {
        String[] words = {"hot","dot","dog","lot","log","cog" };
        List<String> list = new ArrayList<>();
        list.addAll(Arrays.asList(words));
        System.out.println(this.ladderLength("hit", "cog", list));
    }
}

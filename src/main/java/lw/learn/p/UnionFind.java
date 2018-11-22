package lw.learn.p;


import java.util.HashMap;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-11-22 10:16:46
 **/
public class UnionFind {

    public static class Node {

    }

    public static class UnionFindSet {
        HashMap<Node, Node> fatherMap;
        HashMap<Node, Integer> sizeMap;

        public UnionFindSet(List<Node> nodes) {
            makeSets(nodes);
        }

        private void makeSets(List<Node> nodes) {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        private Node findHead(Node node) {

            return null;
        }

        public boolean isSameSet(Node a, Node b) {

            return false;
        }

        public void union(Node a, Node b) {

        }
    }
}

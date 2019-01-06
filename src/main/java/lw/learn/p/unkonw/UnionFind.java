package lw.learn.p.unkonw;


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
        HashMap<Node, Integer> rankMap;

        public UnionFindSet(List<Node> nodes) {
            makeSets(nodes);
        }

        private void makeSets(List<Node> nodes) {
            fatherMap = new HashMap<>();
            rankMap = new HashMap<>();
            for (Node node : nodes) {
                fatherMap.put(node, node);
                rankMap.put(node, 1);
            }
        }

        private Node findHead(Node node) {

            Node father = fatherMap.get(node);
            if (father != node) {
                father = findHead(father);
            }
            fatherMap.put(node, father);
            return father;
        }

        public boolean isSameSet(Node a, Node b) {

            return a== b || findHead(a) == findHead(b);
        }

        public void union(Node a, Node b) {
            if (a == b) {
                return;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (aHead == bHead) {
                return;
            }
            Integer arank = rankMap.get(aHead);
            Integer brank = rankMap.get(b);
            if (arank > brank) {
                fatherMap.put(bHead, aHead);
            } else if (arank < brank) {
                fatherMap.put(aHead, bHead);
            } else {
                fatherMap.put(bHead, aHead);
                rankMap.put(aHead, arank + 1);
            }
        }
    }
}

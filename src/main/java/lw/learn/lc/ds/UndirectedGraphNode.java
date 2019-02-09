package lw.learn.lc.ds;

import java.util.*;

/**
 * @Author lw
 * @Date 2019-02-08 20:55:21
 **/
public class UndirectedGraphNode {

    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<>();
    }

    public static void printGraph(UndirectedGraphNode root) {
        List<String> res = new LinkedList<>();
        Set<UndirectedGraphNode> visited = new HashSet<>();
        printGraph(root, res, visited);
        System.out.println(res);
    }

    private static void printGraph(UndirectedGraphNode node, List<String> res, Set<UndirectedGraphNode> visited) {
        if (node == null) {
            return;
        }
        if (visited.contains(node)) {
            return;
        }
        res.add("#" + node.label);
        visited.add(node);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            res.add(String.valueOf(neighbor.label));
        }

        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (neighbor.label != node.label) {
                printGraph(neighbor, res, visited);
            }
        }
    }
}

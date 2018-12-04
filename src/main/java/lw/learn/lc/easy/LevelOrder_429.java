package lw.learn.lc.easy;

import lw.learn.lc.ds.Node;
import org.junit.Test;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-04 22:39:34
 **/
public class LevelOrder_429 {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Node endOfLevel = root;
        Node nextLevel = null;
        LinkedList<Node> queue = new LinkedList<>();
        List<Integer> nodes = new ArrayList<>(1000);
        queue.add(root);
        while (!queue.isEmpty()) {
            Node cur = queue.pop();
            nodes.add(cur.val);
            if (cur.children != null) {
                for (Node child : cur.children) {
                    nextLevel = child;
                    queue.add(child);
                }
            }
            if (cur == endOfLevel) {
                endOfLevel = nextLevel;
                res.add(new ArrayList<>(nodes));
                nodes.clear();
            }
        }
        return res;
    }
    @Test
    public void test() {
        List list = null;
        for (Object o : list) {
            System.out.println(o);
        }
    }
}

package lw.learn.lc.ds;

import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-04 22:39:04
 **/
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

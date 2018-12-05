package lw.learn.lc.easy;

import lw.learn.lc.ds.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-05 11:07:16
 **/
public class Preorder_589 {

    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        preorder(root, res);
        return res;
    }

    private void preorder(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        if (node.children != null) {
            for (Node child : node.children) {
                preorder(child, list);
            }
        }
    }
}

package lw.learn.lc.easy;

import lw.learn.lc.ds.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author lw
 * @Date 2018-12-05 11:08:52
 **/
public class Postorder_590 {

    List<Integer> res = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return res;
        }

        for (Node child : root.children) {
            postorder(child);
        }
        res.add(root.val);
        return res;
    }
}

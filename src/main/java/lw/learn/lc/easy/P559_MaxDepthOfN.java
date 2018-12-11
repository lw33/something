package lw.learn.lc.easy;

import lw.learn.lc.ds.Node;

/**
 * @Author lw
 * @Date 2018-12-05 11:12:23
 **/
public class P559_MaxDepthOfN {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }

        return max + 1;
    }


}

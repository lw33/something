package lw.learn.lc.tree.fastest;

import lw.learn.lc.ds.TreeLinkNode;

/**
 * @Author lw
 * @Date 2019-01-16 21:50:18
 **/
public class P116_PopulatingNextRightPointersInEachNode {
    public class Solution {
        public void connect(TreeLinkNode root) {
            help(root);
        }

        public void help(TreeLinkNode prehead){
            if(prehead == null || prehead.left == null)
                return;
            TreeLinkNode headOfLine = prehead.left;
            TreeLinkNode temp = headOfLine;
            while(prehead != null){
                TreeLinkNode left = prehead.left;
                TreeLinkNode right = prehead.right;
                temp.next = left;
                temp = temp.next;
                temp.next = right;
                temp = temp.next;
                prehead = prehead.next;
            }
            help(headOfLine);
        }
    }
}

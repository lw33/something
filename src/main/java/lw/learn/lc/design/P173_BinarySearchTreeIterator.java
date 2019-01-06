package lw.learn.lc.design;

import lw.learn.lc.ds.TreeNode;

import java.util.LinkedList;

/**
 * @Author lw
 * @Date 2019-01-06 16:15:14
 **/
public class P173_BinarySearchTreeIterator {

    class BSTIterator {
        private LinkedList<Integer> linkedList;
        public BSTIterator(TreeNode root) {
            linkedList = new LinkedList<>();
            inOrder(root);
        }

        private void inOrder(TreeNode node) {
            if (node == null) {
                return;
            }

            inOrder(node.left);
            linkedList.offer(node.val);
            inOrder(node.right);
        }

        /** @return the next smallest number */
        public int next() {
            if (hasNext()) {
                return linkedList.poll();
            }
            return -1;
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {

            return linkedList.size() > 0;
        }
    }
}

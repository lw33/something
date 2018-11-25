package lw.learn.p.z.tree;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-11-25 21:12:49
 **/
public class MaxSubBST {

    class ResultData {

        TreeNode head;
        int size;
        int max;
        int min;

        public ResultData(TreeNode head, int size, int max, int min) {
            this.head = head;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    public ResultData maxSubBST(TreeNode head) {
        if (head == null) {
            return new ResultData(null, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }
        ResultData leftData = maxSubBST(head.left);
        ResultData rightData = maxSubBST(head.right);
        if (head.left == leftData.head &&
                head.right == rightData.head &&
                head.val > leftData.max &&
                head.val < rightData.min) {
            // TODO: 2018/11/25   
        }
        int maxSize;
        int maxHead;
        int max;
        int min;
        return new ResultData(head, leftData.size + rightData.size + 1, Math.max(rightData.max, head.val), Math.min(leftData.min, head.val));
    }
}

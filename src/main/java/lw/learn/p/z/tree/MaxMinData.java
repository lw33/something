package lw.learn.p.z.tree;

import lw.learn.lc.ds.TreeNode;

/**
 * @Author lw
 * @Date 2018-11-25 21:37:17
 **/
public class MaxMinData {

    class ReturnData {
        int min;
        int max;

        public ReturnData(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    private ReturnData getMaxMin(TreeNode head) {

        if (head == null) {
            return new ReturnData(Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        ReturnData leftData = getMaxMin(head.left);
        ReturnData rightData = getMaxMin(head.right);
        return new ReturnData(Math.min(Math.min(leftData.min, rightData.min), head.val),
                Math.max(Math.max(leftData.max, rightData.max), head.val));
    }

    public void maxMin(TreeNode head) {
        ReturnData maxMin = getMaxMin(head);
        System.out.println(maxMin.max + " " + maxMin.min);
    }
}
